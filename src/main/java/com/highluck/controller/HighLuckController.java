package com.highluck.controller;

import java.util.ArrayList;


import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.highluck.biz.ListBiz;
import com.highluck.dto.ListDTO;

@Controller
public class HighLuckController {

	Logger log = Logger.getLogger(this.getClass());

	    @RequestMapping(value="/goods.do")
	    public ModelAndView ListPage() throws Exception{
	    	ModelAndView mv = new ModelAndView("/BoardList");
	    	System.out.println("good");
	    	ArrayList<ListDTO> list = new ListBiz().SelectList();
	    	mv.addObject("list", list);
	    	
	    	return mv;    	
	    }
}
