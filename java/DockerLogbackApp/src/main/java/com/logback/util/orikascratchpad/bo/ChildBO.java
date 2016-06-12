package com.logback.util.orikascratchpad.bo;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true,exclude={"parent"})
public class ChildBO {

    private Integer id;
    
    private String fname;
    
    private String lname;
    
    private ParentBO parent;
    
    private List<SubjectBO> subjects;

        
}
