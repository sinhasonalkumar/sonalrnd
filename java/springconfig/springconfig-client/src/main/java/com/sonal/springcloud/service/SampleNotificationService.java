package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.SampleNotificationServiceResponseVO;

@Service
@RefreshScope
public class SampleNotificationService implements ISampleNotificationService {

    private Logger logger = LoggerFactory.getLogger(SampleNotificationService.class);
    
    @Value("${fromNumber}")
    private String fromNumber;
    
    @Override
    public CompletableFuture<SampleNotificationServiceResponseVO> sendNotification(String userName){
        return CompletableFuture.supplyAsync(() -> sendSms(userName));
    }

    private SampleNotificationServiceResponseVO sendSms(String userName) {
        SampleNotificationServiceResponseVO coreServiceResponseVO = new SampleNotificationServiceResponseVO();
        String message = "Messaage Sent :: Hello " + userName + " From :: " + fromNumber;
	logger.info(message );
        coreServiceResponseVO.setMessage(message);
        return coreServiceResponseVO;
    }
}
