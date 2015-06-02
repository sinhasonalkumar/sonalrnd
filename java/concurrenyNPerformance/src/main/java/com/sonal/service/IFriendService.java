package com.sonal.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

public interface IFriendService {

    ListenableFuture<List<String>> findDirectFriendNamesWay1(String userName, Integer pageNo);

    Future<List<String>> findDirectFriendNamesWay2(String userName, Integer pageNo);

}