package com.sonal.service.vo.builder;

import java.util.List;

import com.sonal.persistence.bo.CustomerBO;
import com.sonal.persistence.bo.GatewayBO;
import com.sonal.service.vo.CustomerDeviceInfoVO;

public class CustomerDeviceInfoVOBuilder {

    public static CustomerDeviceInfoVO build(CustomerBO customerBO, List<GatewayBO> gateways){
	CustomerDeviceInfoVO customerDeviceInfo = new CustomerDeviceInfoVO();
	return customerDeviceInfo;
    }
}
