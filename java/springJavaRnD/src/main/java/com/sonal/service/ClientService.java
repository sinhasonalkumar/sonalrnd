package com.sonal.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.sonal.vo.StateVO;

@Service
@EnableAsync
public class ClientService {

    @Async
    public Future<StateVO> invokeClientByAsync(int noOfRecords) throws Throwable {
	System.out.println("Client Invoke Start");
	StateVO stateVO = new StateVO();
	if (noOfRecords <= 50) {
	    Thread.sleep(3000);
	    System.out.println("Record Fetched By invokeClientByAsync.....");
	    stateVO.setAbc("completedByAsync");
	    stateVO.setXyz("completedByAsync");
	}
	if (noOfRecords > 50) {
	    Thread.sleep(7000);
	    System.out.println("Record Fetched By invokeClientByAsync.....");
	    stateVO.setAbc("completedByAsync");
	    stateVO.setXyz("completedByAsync");
	}
	System.out.println("Client Invoke End");
	Future<StateVO> futureStateVO = new AsyncResult<StateVO>(stateVO);
	return futureStateVO;
    }

    public StateVO invokeClient(int noOfRecords) throws Throwable {
	System.out.println("Client Invoke Start");
	StateVO stateVO = new StateVO();
	if (noOfRecords <= 50) {
	    Thread.sleep(3000);
	    System.out.println("Record Fetched By invokeClient.....");
	    stateVO.setAbc("completedNormally");
	    stateVO.setXyz("completedNormally");
	}
	if (noOfRecords > 50) {
	    Thread.sleep(7000);
	    System.out.println("Record Fetched By invokeClient.....");
	    stateVO.setAbc("completedNormally");
	    stateVO.setXyz("completedNormally");
	}
	System.out.println("Client Invoke End");
	return stateVO;
    }
}
