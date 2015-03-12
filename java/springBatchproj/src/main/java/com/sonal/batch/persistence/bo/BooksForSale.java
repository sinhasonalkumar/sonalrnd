package com.sonal.batch.persistence.bo;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BooksForSale {

    private UUID id;
    private String bookName;
    private BookType bookType;
    private BigDecimal price;
    private Long count;
  
}
