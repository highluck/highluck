package com.peoplejob.dao;

import java.util.ArrayList;
import com.peoplejob.common.AbstractDAO;
import com.peoplejob.dto.ListDTO;

public class ListDAO extends AbstractDAO{
	
		public ArrayList<ListDTO> selectMainList() throws Exception{
	        return (ArrayList<ListDTO>)selectList("List.selectList");
	    }
}
