package com.sonal.test.app.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.sonal.config.config.PerfAppConfig;
import com.sonal.service.IFriendService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PerfAppConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class FriendServiceTest {

    @Autowired
    private IFriendService friendService;

    private static String userName;

    private static int friendCount;

    @BeforeClass
    public static void descideLoad() {

	userName = "abc";
	friendCount = 50000;
    }

    @Test
    public void testFindDirectFriendNamesWay1() {

	int pageSize = 10;

	int noOfPages = friendCount / pageSize;

	ListenableFuture<List<String>> futureResp = null;
	final List<ListenableFuture<List<String>>> futureResps = new CopyOnWriteArrayList<ListenableFuture<List<String>>>();

	for (int pageNo = 0; pageNo < noOfPages; pageNo++) {
	    futureResp = friendService.findDirectFriendNamesWay1(userName, pageNo);
	    futureResps.add(futureResp);
	    futureResp.addCallback(new ListenableFutureCallback<List<String>>() {

		@Override
		public void onSuccess(List<String> friendNames) {
		    for (String friendName : friendNames) {
			System.out.println(friendName);
		    }
		    
		    System.out.println("**************************************");
		}

		@Override
		public void onFailure(Throwable arg0) {

		}

	    });

	}
	
	while(futureResps.size() != 0){
	    for (ListenableFuture<List<String>> listenableFuture : futureResps) {
		if(listenableFuture.isDone()){
		    futureResps.remove(listenableFuture);
		}
	    }
	}

    }

}
