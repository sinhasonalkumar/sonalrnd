package com.sonal.service.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GatewayVO {

    private String gatewayId;
    
    private List<SensorVO> sensors;
}
