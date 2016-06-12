package com.logback.util.orikascratchpad;


import com.logback.util.orikascratchpad.adapter.ParentObjectConverter;
import com.logback.util.orikascratchpad.bo.ParentBO;
import com.logback.util.orikascratchpad.clientvo.ParentVO;
import com.logback.util.orikascratchpad.dao.ParentDao;

public class MainObjectMapper {
    
    public static void main(String[] args) {
	
	System.out.println("****************************Start**************************************");
	
	ParentBO parentBO = ParentDao.fetchFromDB();

	System.out.println(parentBO);
	
	ParentVO parentVO = ParentObjectConverter.getInstance().convertToVO(parentBO);
	
	System.out.println(parentVO);
	
	parentBO = ParentObjectConverter.getInstance().convertToBO(parentVO);
	
	System.out.println(parentBO);
	
	System.out.println("****************************End**************************************");

    }

   
    
   
}
