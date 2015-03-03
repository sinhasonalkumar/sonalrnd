package com.sonal.thread.callablepak;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<MyCallableDummnyVO> {

    @Override
    public MyCallableDummnyVO call() throws Exception {
	MyCallableDummnyVO callableDummnyVO = new MyCallableDummnyVO();
	Random random = new Random();
	int sleepTime = random.nextInt(3000);
	if (sleepTime > 1500) {
	    throw new Exception(" Sleeping Time is too long");
	}else{
	    Thread.sleep(sleepTime);
	}
	callableDummnyVO.setMessage("Executed Successfully");
	return callableDummnyVO;
    }

}
