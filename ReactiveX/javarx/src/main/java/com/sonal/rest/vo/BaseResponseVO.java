package com.sonal.rest.vo;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponseVO extends ResourceSupport {

    private boolean isSuccess;
    private String successMesage;
    private  HttpStatus httpStatus;
    private String errorMessage;
    private List<String> warnings;
   
    
}
