package com.logback.util.orikascratchpad.adapter;



import com.logback.util.orikascratchpad.bo.BookBO;
import com.logback.util.orikascratchpad.bo.ChildBO;
import com.logback.util.orikascratchpad.bo.ParentBO;
import com.logback.util.orikascratchpad.clientvo.BookVO;
import com.logback.util.orikascratchpad.clientvo.ChildVO;
import com.logback.util.orikascratchpad.clientvo.ParentVO;
import com.logback.util.orikascratchpad.util.BookMapListConverter;
import com.logback.util.orikascratchpad.util.ObjectMapperFactory;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;

public class ParentObjectConverter {
    
    private static final ParentObjectConverter instance = init();
    private ParentObjectConverter(){}
    
    private static ParentObjectConverter init(){
	ParentObjectConverter parentObjectConverter = new ParentObjectConverter();
	configureMapper();
	return parentObjectConverter;
    }
    
    public static ParentObjectConverter getInstance(){
	return instance;
    }
    
    private static MapperFactory configureMapper() {
	MapperFactory mapperFactory = ObjectMapperFactory.getInstance();
      	ConverterFactory converterFactory = mapperFactory.getConverterFactory();
      	
      	converterFactory.registerConverter("bookMapListConverter", BookMapListConverter.getInstance());
      	
      	mapperFactory.classMap(ParentBO.class, ParentVO.class)
      		     .field("fname", "name")
      		     .fieldMap("booksMap", "booksList").converter("bookMapListConverter")
      		     .add()
      		     .byDefault()
      		     .register();
      	
      	
      	mapperFactory.classMap(ChildBO.class, ChildVO.class)
		     .field("fname", "name")
		     .byDefault()
		     .register();
      	
      	
      	mapperFactory.classMap(BookBO.class, BookVO.class)
	     .field("name", "bookName")
	     .byDefault()
	     .register();


      	
      	
   	return mapperFactory;
    }

    public ParentVO convertToVO(ParentBO parentBO) {
   	BoundMapperFacade<ParentBO, ParentVO> mapperFacade = ObjectMapperFactory.getInstance().getMapperFacade(ParentBO.class,ParentVO.class);
   	ParentVO parentVO = mapperFacade.map(parentBO);
   	return parentVO;
     }
    
    
    public ParentBO convertToBO(ParentVO parentVO) {
   	BoundMapperFacade<ParentVO, ParentBO> mapperFacade = ObjectMapperFactory.getInstance().getMapperFacade(ParentVO.class,ParentBO.class);
   	ParentBO parentBO = mapperFacade.map(parentVO);
   	return parentBO;
    }
}
