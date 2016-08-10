package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;

public interface ICoreService {

    CompletableFuture<CoreServiceResponseVO> findUserInfo(String userName);

}