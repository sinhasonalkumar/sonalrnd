package com.sonal.completablefuture.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true)
public class ResponseB {

    private String result;
    
    private String error;

}
