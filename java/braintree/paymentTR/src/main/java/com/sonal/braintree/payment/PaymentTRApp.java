package com.sonal.braintree.payment;

import static spark.Spark.get;
import static spark.Spark.port;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.text.StrSubstitutor;

import spark.Response;
import spark.Route;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

public class PaymentTRApp {
    private static BraintreeGateway gateway = new BraintreeGateway(
	    Environment.SANDBOX,
	    "",
	    "",
	    ""
            );

    private static String renderHtml(String templateFname, HashMap<String, String> valuesMap) {
        try {
            File formFile = new File(templateFname);
            String formTemplate = FileUtils.readFileToString(formFile);
            StrSubstitutor sub = new StrSubstitutor(valuesMap);
            return sub.replace(formTemplate);
        } catch (IOException e) {
            return "";
        }
    }

    public static void main(String[] args) {
	
	  port(8081);
	
        get("/",new Route() {
            @Override
            public Object handle(spark.Request request, Response response) {
                String customerId = "57290325";
        	// set the response type
                response.type("text/html");

                String braintreeUrl = gateway.transparentRedirect().url();
                TransactionRequest trParams = new TransactionRequest()
                	.orderId(customerId + UUID.randomUUID().toString())
                        .type(Transaction.Type.SALE)
                        .amount(new BigDecimal("1.00"))
                        .options()//.storeInVault(true)
                        .storeInVault(true)
                            .submitForSettlement(true) // this submits transaction request for settlement after doing authorisation 
                            .done();
                trParams.customerId(customerId); //for adding  existing customer but do not store cc

                String trData = gateway.transparentRedirect().trData(trParams, "http://localhost:8081/braintree");

                // return HTML with braintreeUrl and trData intermixed
                HashMap<String, String> valuesMap = new HashMap<String, String>();
                valuesMap.put("braintreeUrl", braintreeUrl);
                valuesMap.put("trData", trData);
                return renderHtml("views/form.html", valuesMap);
            }
        });

        get("/braintree",new Route() {
            @Override
            public Object handle(spark.Request request, Response response) {
                response.type("text/html");
                String queryString = request.queryString();
				Result<Transaction> result = gateway.transparentRedirect().confirmTransaction(queryString);
                String message = "";
                if (result.isSuccess()) {
                    message = result.getTarget().getStatus().toString();
                } else {
                    message = result.getMessage();
                }

                HashMap<String, String> valuesMap = new HashMap<String, String>();
                valuesMap.put("message", message);
                return renderHtml("views/response.html", valuesMap);
            }
        });
    }
}
