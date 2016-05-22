package com.peoplejob.common;

import com.peoplejob.biz.AccountBiz;
import com.peoplejob.biz.AuthBiz;
import com.peoplejob.biz.BoardBiz;
import com.peoplejob.biz.ListBiz;

public class IocContainer {
	
	private ListBiz listBiz;
	private AccountBiz accountBiz;
	private BoardBiz boardBiz;
	private AuthBiz authBiz;
		
	public AuthBiz getAuthBiz() {
		return authBiz;
	}

	public void setAuthBiz(AuthBiz authBiz) {
		this.authBiz = authBiz;
	}

	public BoardBiz getBoardBiz() {
		return boardBiz;
	}

	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	public AccountBiz getAccountBiz() {
		return accountBiz;
	}

	public void setAccountBiz(AccountBiz accountBiz) {
		this.accountBiz = accountBiz;
	}

	public void setListBiz(ListBiz listBiz){
		this.listBiz = listBiz;
	}

	public ListBiz getListBiz() {
		return listBiz;
	}
	

}
