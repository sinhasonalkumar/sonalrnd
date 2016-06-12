package com.logback.rest.controller.sns;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SnsSubscriptionRequest {

    private String topicArn;
    private String emailId;
}
