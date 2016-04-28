package com.highluck.common;

import com.highluck.biz.ListBiz;

public class IocContainer {
	
	private ListBiz listBiz;
		
	public void setListBiz(ListBiz listBiz){
		this.listBiz = listBiz;
	}

	public ListBiz getListBiz() {
		return listBiz;
	}

}
