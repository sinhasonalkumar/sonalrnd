package com.logback.rest.controller.sns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
@RequestMapping("/sns")
public class SNSAdminController {
    
    public final Logger logger = LoggerFactory.getLogger(SNSAdminController.class);

    @Autowired
    private AmazonSNSClient amazonSNSClient;
    
    @RequestMapping("/createTopic/{topicName}")
    public DeferredResult<ResponseEntity<String>> createTopic(@PathVariable("topicName") String topicName) {
	
	DeferredResult<ResponseEntity<String>> deferredCreateTopicResult = new DeferredResult<ResponseEntity<String>>();
	
	//create a new SNS topic
	CreateTopicRequest createTopicRequest = new CreateTopicRequest(topicName);
	CreateTopicResult createTopicResult = amazonSNSClient.createTopic(createTopicRequest);
	//print TopicArn
	logger.info("createTopicResult :: "+ createTopicResult);
	//get request id for CreateTopicRequest from SNS metadata		
	logger.info("CreateTopicRequest - " + amazonSNSClient.getCachedResponseMetadata(createTopicRequest));
	
	ResponseEntity<String> result = new ResponseEntity<String>(createTopicResult.getTopicArn(),HttpStatus.OK);
	
	deferredCreateTopicResult.setResult(result);
	
	return deferredCreateTopicResult;
    }
    
    @RequestMapping(value ="/subscriptionRequest", method = RequestMethod.POST , produces = "application/json",consumes ="application/json")
    public DeferredResult<ResponseEntity<String>> subscriptionRequest(@RequestBody SnsSubscriptionRequest snsSubscriptionRequest) {
	
	DeferredResult<ResponseEntity<String>> deferredCreateTopicResult = new DeferredResult<ResponseEntity<String>>();
	
	SubscribeRequest subRequest = new SubscribeRequest(snsSubscriptionRequest.getTopicArn(), "email", snsSubscriptionRequest.getEmailId());
	amazonSNSClient.subscribe(subRequest);
	//get request id for SubscribeRequest from SNS metadata
	System.out.println("SubscribeRequest - " + amazonSNSClient.getCachedResponseMetadata(subRequest));
	System.out.println("Check your email and confirm subscription.");
	
	ResponseEntity<String> result = new ResponseEntity<String>("Sent",HttpStatus.OK);
	
	deferredCreateTopicResult.setResult(result);
	
	return deferredCreateTopicResult;
    }
    
    
    @RequestMapping(value ="/deleteTopic", method = RequestMethod.DELETE , produces = "application/json",consumes ="application/json")
    public DeferredResult<ResponseEntity<String>> deleteTopic(@RequestBody SnsSubscriptionRequest snsSubscriptionRequest) {
	
	DeferredResult<ResponseEntity<String>> deferredCreateTopicResult = new DeferredResult<ResponseEntity<String>>();
	
	 //delete an SNS topic
	    DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(snsSubscriptionRequest.getTopicArn());
	    amazonSNSClient.deleteTopic(deleteTopicRequest);
	    //get request id for DeleteTopicRequest from SNS metadata
	    System.out.println("DeleteTopicRequest - " + amazonSNSClient.getCachedResponseMetadata(deleteTopicRequest));
	
	ResponseEntity<String> result = new ResponseEntity<String>("Deleted",HttpStatus.OK);
	
	deferredCreateTopicResult.setResult(result);
	
	return deferredCreateTopicResult;
    }
    
    
 
}
