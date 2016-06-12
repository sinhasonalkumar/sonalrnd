package com.logback.util.orikascratchpad.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.logback.util.orikascratchpad.bo.BookBO;
import com.logback.util.orikascratchpad.bo.ChildBO;
import com.logback.util.orikascratchpad.bo.ParentBO;
import com.logback.util.orikascratchpad.bo.SubjectBO;

public class ParentDao {

    public static ParentBO fetchFromDB() {

   	ParentBO parentVO = new ParentBO();
   	parentVO.setId(1);
   	parentVO.setFname("Parent_FirstName");
   	parentVO.setLname("Parent_LastName");
   	
   	ChildBO childVO = new ChildBO();
   	childVO.setId(1);
   	childVO.setFname("Child_FirstName");
   	childVO.setLname("Child_LastName");
   	childVO.setParent(parentVO);
   	
   	List<SubjectBO> subjects = new ArrayList<>();
   	SubjectBO subject1 = new SubjectBO();
   	subject1.setName("Java");
   	subjects.add(subject1);
   	childVO.setSubjects(subjects);

   	BookBO book = new BookBO();
   	book.setId(1);
   	book.setName("book1");

   	Map<Integer, ParentBO> parents = new HashMap<Integer, ParentBO>();
   	parents.put(1, parentVO);
   	book.setParents(parents);

   	Map<Integer, BookBO> books = new HashMap<Integer, BookBO>();
   	books.put(1, book);
   	parentVO.setBooksMap(books);

   	Set<ChildBO> children = new HashSet<ChildBO>();
   	children.add(childVO);

   	parentVO.setChildren(children);

   	return parentVO;
       }
}
