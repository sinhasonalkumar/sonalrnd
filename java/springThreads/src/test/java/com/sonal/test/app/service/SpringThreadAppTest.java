package com.sonal.test.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.sonal.config.config.SpringThreadAppConfig;
import com.sonal.context.ServiceRequestVO;
import com.sonal.service.MasterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringThreadAppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class SpringThreadAppTest {

    @Autowired
    private MasterService masterService;

    @Test
    public void testKickOffProcess() throws InterruptedException {

	Thread thread1 = new Thread( new Runnable() {

	    @Override
	    public void run() {
		ServiceRequestVO serviceRequestVO = new ServiceRequestVO();
		serviceRequestVO.setRequestId("SR1");
		masterService.kickOffProcess(serviceRequestVO);

	    }
	});

	thread1.start();
	
	

	Thread thread2 = new Thread( new Runnable() {

	    @Override
	    public void run() {
		ServiceRequestVO serviceRequestVO = new ServiceRequestVO();
		serviceRequestVO.setRequestId("SR2");
		masterService.kickOffProcess(serviceRequestVO);

	    }
	});
	
	thread2.start();
	
	
	thread1.join();
	thread2.join();
	
	
	
	Thread thread3 = new Thread( new Runnable() {

	    @Override
	    public void run() {
		ServiceRequestVO serviceRequestVO = new ServiceRequestVO();
		serviceRequestVO.setRequestId("SR3");
		masterService.kickOffProcess(serviceRequestVO);

	    }
	});
	
	thread3.start();
	thread3.join();
	
	Thread thread4 = new Thread( new Runnable() {

	    @Override
	    public void run() {
		ServiceRequestVO serviceRequestVO = new ServiceRequestVO();
		serviceRequestVO.setRequestId("SR4");
		masterService.kickOffProcess(serviceRequestVO);

	    }
	});
	
	thread4.start();
	thread4.join();
	
    }
}
