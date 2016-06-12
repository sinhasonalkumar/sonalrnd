package com.logback.util.orikascratchpad.clientvo;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames=true,exclude={"children","booksList"})
public class ParentVO {

    private Integer id;

    private String name;

    private Set<ChildVO> children;

    // private Map<Integer, ClientBookVO> books;

    private List<BookVO> booksList;

}
