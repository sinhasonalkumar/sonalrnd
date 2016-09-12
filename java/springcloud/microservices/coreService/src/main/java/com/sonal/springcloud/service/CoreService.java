package com.sonal.springcloud.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sonal.springcloud.rest.vo.CoreServiceResponseVO;

@Service
public class CoreService implements ICoreService {

    private Logger logger = LoggerFactory.getLogger(CoreService.class);
    
    @Override
    public CompletableFuture<CoreServiceResponseVO> findUserInfo(String userName){
        return CompletableFuture.supplyAsync(() -> findUser(userName));
    }

    private CoreServiceResponseVO findUser(String userName) {
        CoreServiceResponseVO coreServiceResponseVO = new CoreServiceResponseVO();
        String mobileNo = "+1123456789";
        logger.info("Found User :: " + userName + " Mobile Number :: " + mobileNo );
        coreServiceResponseVO.setMessage(mobileNo);
        return coreServiceResponseVO;
    }
}
