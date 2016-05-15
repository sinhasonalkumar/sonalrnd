package com.sonal.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.service.vo.CustomerDeviceInfoVO;

public interface IGatewayDeviceService {
 
    CompletableFuture<CustomerDeviceInfoVO> findCustomerDeviceInfoAsync(String customerId);
}
