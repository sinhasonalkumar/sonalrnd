package com.logback.util.orikascratchpad.clientvo;




import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames = true,exclude = {"parents"})
public class BookVO {

    private Integer id; 
    
    private String bookName;
    
   // private Map<Integer, ParentVO> parents;
    private Set<ParentVO> parents;
        
}
