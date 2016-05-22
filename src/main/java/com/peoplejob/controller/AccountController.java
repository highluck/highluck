package com.peoplejob.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peoplejob.common.IocContainer;


import com.peoplejob.dto.account.Account;
import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.dto.response.LoginResponse;
import com.peoplejob.library.Json;

@Controller
public class AccountController {

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IocContainer ioc;

	  @RequestMapping(value="/accounts/login.do", method = RequestMethod.POST)
	  public void Login(@RequestBody AccountFilter filter, HttpServletResponse response){
		  LoginResponse result = new LoginResponse();
		  try{
				result = ioc.getAccountBiz().Login(filter);	
			
			}catch(Exception e){
				result.setReason("등록된 Email이아닙니다.");
				result.setResult("false");
				result.setToken(null);
			}
		  Json.getJson().ReturnJSON(response, result);
	  }
	  
	  @RequestMapping(value="/accounts/signup.do", method = RequestMethod.POST)
	  public void SetAccount(@RequestBody Account account, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getAccountBiz().SetAccount(account));		  
	  }
	  
	  @RequestMapping(value="/accounts.do", method = RequestMethod.GET)
	  public void GetAccount(@ModelAttribute AccountFilter filter, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getAccountBiz().GetAccount(filter));		  
	  }
}
