package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

public interface INotificationService {

    CompletableFuture<NotificationServiceResponseVO> sendNotification(String userName, String body);

}