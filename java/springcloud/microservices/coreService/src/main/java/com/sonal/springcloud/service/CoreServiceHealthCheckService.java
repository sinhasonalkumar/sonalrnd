package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;

@Service
public class CoreServiceHealthCheckService implements ICoreServiceHealthCheckService {

    @Override
    public CompletableFuture<CoreServiceResponseVO> checkHealth(){
        return CompletableFuture.supplyAsync(() -> buildHealthCheckResponseVO("Healthy"));
    }
    
    private CoreServiceResponseVO buildHealthCheckResponseVO(String message){
        CoreServiceResponseVO coreServiceResponseVO = new CoreServiceResponseVO();
        coreServiceResponseVO.setMessage(message);
        return coreServiceResponseVO;
    }
}
