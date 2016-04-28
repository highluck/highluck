package com.highluck.biz;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highluck.dao.ListDAO;
import com.highluck.dto.ListDTO;


public class ListBiz {
	
	private ListDAO listDao;
	public int x;
	
	
	public void setListDao(ListDAO listDao){
		this.listDao = listDao;		
	}	
	
	public ArrayList<ListDTO> SelectList() throws Exception{	
		System.out.println(x);
		return (ArrayList<ListDTO>) listDao.selectMainList();
	}
}
