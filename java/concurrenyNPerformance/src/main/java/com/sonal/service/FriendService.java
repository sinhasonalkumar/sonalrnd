package com.sonal.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class FriendService implements IFriendService {

    @Autowired
    private IThirdPartyClient thirdPartyClient;

    @Override
    @Async
    public ListenableFuture<List<String>> findDirectFriendNamesWay1(String userName, Integer pageNo) {

	List<String> directFiendNames = null;

	directFiendNames = thirdPartyClient.someTimeTakingOperation();

	ListenableFuture<List<String>> resp = new AsyncResult<List<String>>(directFiendNames);

	return resp;
    }

    @Override
    @Async
    public Future<List<String>> findDirectFriendNamesWay2(String userName, Integer pageNo) {

	List<String> directFiendNames = null;

	directFiendNames = thirdPartyClient.someTimeTakingOperation();

	ListenableFuture<List<String>> resp = new AsyncResult<List<String>>(directFiendNames);

	return resp;
    }

}
