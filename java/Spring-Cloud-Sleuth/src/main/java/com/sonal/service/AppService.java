package com.sonal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private static Logger log = LoggerFactory.getLogger(AppService.class);

    @Autowired
    private AuditService auditService;

    public void doSomething() {
	auditService.doAudit();
	log.info("Doing Something");
    }
}
