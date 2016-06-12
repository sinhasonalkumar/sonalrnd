package com.logback.util.orikascratchpad.clientvo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true,exclude={"parent"})
public class ChildVO {

    private Integer id;
    
    private String name;
    
    private ParentVO parent;

        
}
