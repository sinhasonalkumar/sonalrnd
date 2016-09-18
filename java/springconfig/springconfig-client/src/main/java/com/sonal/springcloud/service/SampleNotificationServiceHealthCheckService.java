package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.SampleNotificationServiceResponseVO;

@Service
public class SampleNotificationServiceHealthCheckService implements ISampleNotificationServiceHealthCheckService {

    @Override
    public CompletableFuture<SampleNotificationServiceResponseVO> checkHealth(){
        return CompletableFuture.supplyAsync(() -> buildHealthCheckResponseVO("Healthy"));
    }
    
    private SampleNotificationServiceResponseVO buildHealthCheckResponseVO(String message){
        SampleNotificationServiceResponseVO coreServiceResponseVO = new SampleNotificationServiceResponseVO();
        coreServiceResponseVO.setMessage(message);
        return coreServiceResponseVO;
    }
}
