package com.sonal.batch.vo;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BooksFeed {

    private String bookName;
    private String bookType;
    private Long count;
    private BigDecimal price;
    
}
