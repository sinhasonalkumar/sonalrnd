package com.logback.util.orikascratchpad.util;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ObjectMapperFactory {

    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    
    private ObjectMapperFactory(){}
    
    public static MapperFactory getInstance(){
	return mapperFactory;
    }
}
