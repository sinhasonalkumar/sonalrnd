package com.sonal.persistence.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookBO implements Serializable {

    private String bookName;
}
