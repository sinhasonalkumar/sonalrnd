package com.logback.util.orikascratchpad.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logback.util.orikascratchpad.bo.BookBO;
import com.logback.util.orikascratchpad.clientvo.BookVO;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class BookMapListConverter extends BidirectionalConverter<Map<Integer, BookBO>, List<BookVO>> {

    private static final BookMapListConverter instnace = new BookMapListConverter();

    private BookMapListConverter() {
    }

    @Override
    public List<BookVO> convertTo(Map<Integer, BookBO> source, Type<List<BookVO>> destinationType) {
	List<BookVO> clientBookVOs = new ArrayList<BookVO>();
	BookVO clientBookVO = null;

	for (BookBO bookVO : source.values()) {
	    clientBookVO = ObjectMapperFactory.getInstance().getMapperFacade(BookBO.class, BookVO.class).map(bookVO);
	    clientBookVOs.add(clientBookVO);
	}

	return clientBookVOs;
    }

    @Override
    public Map<Integer, BookBO> convertFrom(List<BookVO> source, Type<Map<Integer, BookBO>> destinationType) {

	Map<Integer, BookBO> bookVOs = new HashMap<Integer, BookBO>();
	BookBO bookVO = null;
	for (BookVO clientBook : source) {
	    bookVO = ObjectMapperFactory.getInstance().getMapperFacade(BookVO.class, BookBO.class).map(clientBook);
	    bookVOs.put(bookVO.getId(), bookVO);
	}

	return bookVOs;
    }

    public static BookMapListConverter getInstance() {
	return instnace;
    }

}
