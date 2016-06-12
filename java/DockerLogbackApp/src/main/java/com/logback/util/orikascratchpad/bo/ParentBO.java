package com.logback.util.orikascratchpad.bo;


import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(includeFieldNames=true,exclude={"children","booksMap"})
public class ParentBO {

    private Integer id;
    
    private String fname;
    
    private String lname;
    
    private Set<ChildBO> children;
    
    private Map<Integer, BookBO> booksMap;
    
}
