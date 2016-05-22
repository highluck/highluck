package com.peoplejob.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.peoplejob.biz.ListBiz;
import com.peoplejob.common.IocContainer;

import com.peoplejob.dto.ListDTO;
import com.peoplejob.library.Json;


@Controller
public class HighLuckController {

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IocContainer ioc;

				
	    @RequestMapping(value="/goods.do")
	    public ModelAndView ListPage() throws Exception{
	    	ModelAndView mv = new ModelAndView("/BoardList");	    	
	    	ArrayList<ListDTO> list = new ListBiz().SelectList();
	    	mv.addObject("list", list);	    	
	    	return mv;    	
	    }
	   	    
	    @RequestMapping(value="/goodlist.do")
	    public void ListJson(HttpServletRequest request, HttpServletResponse response) throws Exception{	    		    		    		    	
	    	Json.getJson().ReturnJSON(response, ioc.getListBiz().SelectList()); 	    		    	    
	    }	   
}
