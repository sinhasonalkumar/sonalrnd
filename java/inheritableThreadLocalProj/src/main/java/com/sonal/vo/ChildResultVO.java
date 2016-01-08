package com.sonal.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChildResultVO {

    private boolean childService1Done;
    private boolean childService1Success;
    private Throwable childService1Error;
    
    private boolean childService2Done;
    private boolean childService2Success;
    private Throwable childService2Error;
}
