package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.springcloud.rest.vo.SampleNotificationServiceResponseVO;

public interface ISampleNotificationServiceHealthCheckService {

    CompletableFuture<SampleNotificationServiceResponseVO> checkHealth();    

}