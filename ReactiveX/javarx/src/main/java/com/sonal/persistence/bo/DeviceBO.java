package com.sonal.persistence.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DeviceBO {

    private String id;
 
    private String name;
    
    private List<SensorBO> sesnsors;
}
