package com.sonal.completablefuture.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true)
public class ResponseA {

    private String result;
    
    private String error;
}
