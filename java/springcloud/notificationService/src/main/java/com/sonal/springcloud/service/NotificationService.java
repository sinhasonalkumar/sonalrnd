package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sonal.springcloud.rest.vo.CoreServiceRequestVO;
import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;
import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

@Service
public class NotificationService implements INotificationService {

    private Logger logger = LoggerFactory.getLogger(NotificationService.class);
    
    @Autowired
    RestTemplate restTemplate;
    
    @Override
    public CompletableFuture<NotificationServiceResponseVO> sendNotification(String userName,String body){
        return CompletableFuture.supplyAsync(() -> sendSMS(userName, body));
    }
    
    public NotificationServiceResponseVO sendSMS(String userName,String body){
        NotificationServiceResponseVO notificationServiceResponseVO = new NotificationServiceResponseVO();
        
        CoreServiceRequestVO coreServiceRequestVO = new CoreServiceRequestVO();
        coreServiceRequestVO.setUserName(userName);
        
        HttpEntity<CoreServiceRequestVO> requestEntity = new HttpEntity<CoreServiceRequestVO>(coreServiceRequestVO);
        
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
}
