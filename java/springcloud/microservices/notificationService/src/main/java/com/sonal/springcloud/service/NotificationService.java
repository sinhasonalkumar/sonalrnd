package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.CoreServiceRequestVO;
import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

@Service
public class NotificationService implements INotificationService {

    //private Logger logger = LoggerFactory.getLogger(NotificationService.class);
    
    @Autowired
    private ISmsService smsService;
    
    @Override
    public CompletableFuture<NotificationServiceResponseVO> sendNotification(String userName,String body){
        return CompletableFuture.supplyAsync(() -> sendSMS(userName, body));
    }
    
    public NotificationServiceResponseVO sendSMS(String userName,String body){
        NotificationServiceResponseVO notificationServiceResponseVO = null;
        
        CoreServiceRequestVO coreServiceRequestVO = new CoreServiceRequestVO();
        coreServiceRequestVO.setUserName(userName);
        
        notificationServiceResponseVO = smsService.getMobileNumberAndSendSMS(coreServiceRequestVO); 
        
        return notificationServiceResponseVO;
    }
    
    
}
