package com.sonal.persistence.bo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class GatewayBO {

    @Id
    private String id;
    
    @Version
    private Integer version;
    
    private String customerId;
    
    private List<DeviceBO> devices;
}
