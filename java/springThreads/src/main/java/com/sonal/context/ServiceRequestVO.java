package com.sonal.context;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceRequestVO {

    private String requestId;
    
    private int progress;
    
    private boolean isDone;
}
