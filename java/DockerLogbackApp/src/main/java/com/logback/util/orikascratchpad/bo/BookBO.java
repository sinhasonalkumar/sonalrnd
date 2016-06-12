package com.logback.util.orikascratchpad.bo;


import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true,exclude={"parents"})
public class BookBO {
    
    private Integer id;
    
    private String name;
    
    private Map<Integer, ParentBO> parents;

        
}
