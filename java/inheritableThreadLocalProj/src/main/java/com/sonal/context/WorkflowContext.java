package com.sonal.context;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true)
public class WorkflowContext {

    private String requestId;
    
    private String userId;
}
