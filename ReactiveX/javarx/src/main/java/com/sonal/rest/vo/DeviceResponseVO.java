package com.sonal.rest.vo;

import com.sonal.service.vo.CustomerDeviceInfoVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeviceResponseVO  extends BaseResponseVO {

    private CustomerDeviceInfoVO customerDeviceInfo;
}
