package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

@Service
public class NotificationServiceHealthCheckService implements INotificationServiceHealthCheckService {

    @Override
    public CompletableFuture<NotificationServiceResponseVO> checkHealth(){
        return CompletableFuture.supplyAsync(() -> buildHealthCheckResponseVO("Healthy"));
    }
    
    private NotificationServiceResponseVO buildHealthCheckResponseVO(String message){
        NotificationServiceResponseVO notificationServiceResponseVO = new NotificationServiceResponseVO();
        notificationServiceResponseVO.setMessage(message);
        return notificationServiceResponseVO;
    }
}
