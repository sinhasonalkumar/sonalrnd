package com.sonal.persistence.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubjectBO implements Serializable {

    private String subjectName;
    private List<BookBO> books;
}
