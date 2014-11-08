package com.sonal.app.service.transactiontypes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
@Scope(value = "prototype")
public @interface ReadWriteTransactional {

}
