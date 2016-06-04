package com.highluck.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highluck.biz.ListBiz;

public class IocContainer {
	
	ApplicationContext context;
	 
	public IocContainer(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/context-IocContainer.xml");
	}
	
	public ListBiz getListBiz() {
		ListBiz listBiz = (ListBiz) context.getBean("listBiz");
		return listBiz;
	}

}
