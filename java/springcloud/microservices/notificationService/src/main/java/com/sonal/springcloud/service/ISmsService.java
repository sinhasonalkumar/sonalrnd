package com.sonal.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sonal.springcloud.rest.vo.CoreServiceRequestVO;
import com.sonal.springcloud.rest.vo.NotificationServiceResponseVO;

public interface ISmsService {

    NotificationServiceResponseVO getMobileNumberAndSendSMS(CoreServiceRequestVO coreServiceRequestVO);

}