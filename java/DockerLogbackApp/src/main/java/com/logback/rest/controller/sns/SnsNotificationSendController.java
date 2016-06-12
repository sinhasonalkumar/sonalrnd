package com.logback.rest.controller.sns;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sns")
public class SnsNotificationSendController {

    public final Logger logger = LoggerFactory.getLogger(SnsNotificationSendController.class);

    @Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

   
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sendNotification(@RequestBody SnsNotification notification) {
        
       notificationMessagingTemplate.sendNotification(notification.getTopicName(), notification.getMessage(), notification.getSubject());
    }

}
