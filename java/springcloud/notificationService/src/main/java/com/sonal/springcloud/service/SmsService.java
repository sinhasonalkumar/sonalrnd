package com.sonal.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sonal.springcloud.rest.vo.CoreServiceRequestVO;
import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;
import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

@Service
public class SmsService implements ISmsService {
    
    
 private Logger logger = LoggerFactory.getLogger(NotificationService.class);
    
    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getMobileNumberAndQueueSMS")
    public NotificationServiceResponseVO getMobileNumberAndSendSMS(CoreServiceRequestVO coreServiceRequestVO) {
       
        NotificationServiceResponseVO notificationServiceResponseVO = new NotificationServiceResponseVO();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        
        HttpEntity<CoreServiceRequestVO> requestEntity = new HttpEntity<CoreServiceRequestVO>(coreServiceRequestVO,headers);
        
        
        //if you do not want CORE-SERVICE as load balanced then remove @LoadBalanced from restTemplate definition 
        // ResponseEntity<CoreServiceResponseVO> exchange = this.restTemplate.exchange("http://localhost:9000/coreService/findUser", HttpMethod.POST, requestEntity,CoreServiceResponseVO.class);
        
        // restTemplate definition  :: @LoadBalanced (In URL replace host name and port with service name which acts as loadbalancer of core service )
        ResponseEntity<CoreServiceResponseVO> exchange = this.restTemplate.exchange("http://CORE-SERVICE/coreService/findUser", HttpMethod.POST, requestEntity,CoreServiceResponseVO.class);
        
        CoreServiceResponseVO coreServiceResponseVO = exchange.getBody();
        
        String mobileNumber = coreServiceResponseVO.getMessage();
        
        String message = "Sent SMS to " + mobileNumber;
        logger.info(message);
        
        notificationServiceResponseVO.setMessage(message);
        
        return notificationServiceResponseVO;
    }
    
    

    private NotificationServiceResponseVO getMobileNumberAndQueueSMS(CoreServiceRequestVO coreServiceRequestVO) {
        NotificationServiceResponseVO notificationServiceResponseVO = new NotificationServiceResponseVO();
        String message = "Queued SMS request ";
        
        notificationServiceResponseVO.setMessage(message);
        return notificationServiceResponseVO;
    }
}
