package com.sonal.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.persistence.bo.CustomerBO;
import com.sonal.persistence.bo.GatewayBO;
import com.sonal.persistence.dao.ICustomerDAO;
import com.sonal.persistence.dao.IGatewayDAO;
import com.sonal.service.IGatewayDeviceService;
import com.sonal.service.vo.CustomerDeviceInfoVO;
import com.sonal.service.vo.builder.CustomerDeviceInfoVOBuilder;

@Service
public class GatewayDeviceService implements IGatewayDeviceService {

    @Autowired
    private IGatewayDAO gatewayDAO;

    @Autowired
    private ICustomerDAO customerDAO;

    public CompletableFuture<CustomerDeviceInfoVO> findCustomerDeviceInfoAsync(String customerId) {

	CompletableFuture<CustomerBO> customerBOFuture = CompletableFuture.supplyAsync(() -> {
	    CustomerBO customerBO = customerDAO.findOne(customerId);
	    return customerBO;
	});

	CompletableFuture<List<GatewayBO>> gatewayBOFuture = CompletableFuture.supplyAsync(() -> {
	    List<GatewayBO> gateways = gatewayDAO.findByCustomerId(customerId);
	    return gateways;
	});

	BiFunction<CustomerBO, List<GatewayBO>, CustomerDeviceInfoVO> buildCustomerDeviceInfoVOResult = (customerBO, gateways) -> {
	    CustomerDeviceInfoVO customerDeviceInfoVO = CustomerDeviceInfoVOBuilder.build(customerBO, gateways);
	    return customerDeviceInfoVO;
	};

	CompletableFuture<CustomerDeviceInfoVO> customerDeviceInfoVOFuture = customerBOFuture.thenCombineAsync(gatewayBOFuture, buildCustomerDeviceInfoVOResult);

	return customerDeviceInfoVOFuture;
    }
}
