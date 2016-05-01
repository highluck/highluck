package com.peoplejob.common;

import com.peoplejob.biz.ListBiz;

public class IocContainer {
	
	private ListBiz listBiz;
		
	public void setListBiz(ListBiz listBiz){
		this.listBiz = listBiz;
	}

	public ListBiz getListBiz() {
		return listBiz;
	}

}
