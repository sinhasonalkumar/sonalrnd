package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

public interface INotificationServiceHealthCheckService {

    CompletableFuture<NotificationServiceResponseVO> checkHealth();    

}