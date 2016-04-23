package com.highluck.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highluck.dao.ListDAO;
import com.highluck.dto.ListDTO;


public class ListBiz {
	
	private static ListDAO listDao;
	
	public void setListDao(ListDAO listDao){
		this.listDao = listDao;
		System.out.println("bean :" + listDao.hashCode());
	}
	
	public ArrayList<ListDTO> SelectList() throws Exception{	
		
		return (ArrayList<ListDTO>) listDao.selectMainList();
	}
}
