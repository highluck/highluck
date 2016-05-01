package com.peoplejob.biz;

import java.util.ArrayList;

import com.peoplejob.dao.ListDAO;
import com.peoplejob.dto.ListDTO;


public class ListBiz {
	
	private ListDAO listDao;
	public int x;
	
	
	public void setListDao(ListDAO listDao){
		this.listDao = listDao;		
	}	
	
	public ArrayList<ListDTO> SelectList() throws Exception{	
		System.out.println(x);
		return listDao.selectMainList();
	}
}
