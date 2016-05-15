package com.sonal.service.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDeviceInfoVO {

    private String customerId;
    
    private String customerName;
    
    private List<GatewayVO> geteways;
}
