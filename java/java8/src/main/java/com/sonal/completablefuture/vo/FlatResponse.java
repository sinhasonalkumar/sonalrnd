package com.sonal.completablefuture.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true)
public class FlatResponse {
    private ResponseA responseA; 
    private List<ResponseB> responsesB;
}
