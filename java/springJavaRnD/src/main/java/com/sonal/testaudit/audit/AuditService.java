package com.sonal.testaudit.audit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

	@Async
	public void beforeAudit() throws Throwable {
		Thread.sleep(9000);
		System.out.println("beforeAudit");
	}
	
	@Async
	public void afterAudit() throws Throwable {
		Thread.sleep(9000);
		System.out.println("afterAudit");
	}
	
	@Async
	public void exceptionAudit() throws Throwable {
		Thread.sleep(9000);
		System.out.println("exceptionAudit");
	}
}
