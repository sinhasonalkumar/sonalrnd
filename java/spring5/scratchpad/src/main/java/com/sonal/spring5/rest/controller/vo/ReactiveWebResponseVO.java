package com.sonal.spring5.rest.controller.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames =true)
public class ReactiveWebResponseVO {

    private String message;
}
