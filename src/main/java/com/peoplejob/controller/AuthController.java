package com.peoplejob.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peoplejob.common.IocContainer;
import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.library.Json;

@Controller
public class AuthController {
	
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IocContainer ioc;
	
	  @RequestMapping(value="/auth/email/{email}/overlab.do", method = RequestMethod.GET)
	  public void OverlabEmail(@ModelAttribute AccountFilter filter, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getAuthBiz().OverlabEmail(filter));		  
	  }
	  
	  @RequestMapping(value="/auth/nickname/{nickname}/overlab.do", method = RequestMethod.GET)
	  public void OverlabNickname(@ModelAttribute AccountFilter filter, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getAuthBiz().OverlabNickname(filter));		  
	  }

}
