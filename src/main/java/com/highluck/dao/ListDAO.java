package com.highluck.dao;

import java.util.ArrayList;
import java.util.List;

import com.highluck.common.AbstractDAO;
import com.highluck.dto.ListDTO;

public class ListDAO extends AbstractDAO{
	
		public ArrayList<ListDTO> selectMainList() throws Exception{
	        return (ArrayList<ListDTO>)selectList("List.selectList");
	    }
}
