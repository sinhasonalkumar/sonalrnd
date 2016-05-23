package com.braintree.guide;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.port;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.text.StrSubstitutor;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.CreditCard;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;

public class StotreCCTRApp {
    private static BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "",
            "",
            ""
            );

    static String renderHtml(String templateFname, HashMap<String, String> valuesMap) {
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
	
	port(8082);
	
        Spark.get("/",new Route() {
			
            @Override
            public Object handle(Request request, Response response) {
                // set the response type
                response.type("text/html");

                String braintreeUrl = gateway.transparentRedirect().url();
                CustomerRequest trParams = new CustomerRequest();
                //trParams.customerId("57290325"); //for adding new  credit card information to existing customer
                
                System.out.println(braintreeUrl);
                String trData = gateway.transparentRedirect().trData(trParams, "http://localhost:8082/braintree");
                System.out.println(trData);
                // return HTML with braintreeUrl and trData interpolated
                HashMap<String, String> valuesMap = new HashMap<String, String>();
                valuesMap.put("braintreeUrl", braintreeUrl);
                valuesMap.put("trData", trData);
                HttpServletResponse httpresponse = response.raw();
                HttpServletRequest httprequest = request.raw();
                //httprequest.setAttribute("braintreeUrl", braintreeUrl);
                //httprequest.setAttribute("trData", trData);
               httpresponse.addHeader("braintreeUrl", braintreeUrl);
               httpresponse.addHeader("trData", trData);
             //  httpresponse.addHeader("Location", "http://localhost:8080/Spring4MVCHelloWorld/customerPaymentForm?braintreeUrl=");
              // httpresponse.setStatus(307);
               
                
               
                /*try {
					httpresponse.sendRedirect("http://localhost:8080/Spring4MVCHelloWorld/customerPaymentForm?braintreeUrl=");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
                
               
               // return null;
                return renderHtml("views/form.html", valuesMap);
            }
        });

        Spark.get("/braintree",new Route() {
            @Override
            public Object handle(spark.Request request, Response response) {
                response.type("text/html");
                Result<Customer> result = gateway.transparentRedirect().confirmCustomer(request.queryString());
                Customer customer = result.getTarget();
                List<CreditCard> creditCards = customer.getCreditCards();
                
                for (CreditCard creditCard : creditCards) {
					System.out.println(creditCard.getCreatedAt().getTime());
				}
                // brainTree sorts credit card added.. Latest added cc will on top
                
                String message = "";
                if (result.isSuccess()) {
                    message = customer.getEmail().toString();
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
