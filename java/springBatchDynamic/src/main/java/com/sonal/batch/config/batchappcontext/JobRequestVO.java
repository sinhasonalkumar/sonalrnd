package com.sonal.batch.config.batchappcontext;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobRequestVO {
    
    private String jobRequestId;
    private Map<String, String> stepToTaskLetMap;
     

}
