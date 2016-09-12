package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;

public interface ICoreServiceHealthCheckService {

    CompletableFuture<CoreServiceResponseVO> checkHealth();    

}