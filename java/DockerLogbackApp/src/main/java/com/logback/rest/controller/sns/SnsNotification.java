package com.logback.rest.controller.sns;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SnsNotification {

    private String subject;

    private String message;  
    
    private String topicName;
}
