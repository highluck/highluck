package com.peoplejob.dao;

import com.peoplejob.common.AbstractDAO;
import com.peoplejob.dto.account.AccountFilter;

public class AuthDAO extends AbstractDAO{
	
	public int OverlabEmail(AccountFilter filter){
		
		return (int)selectOne("Auth.overlabEmail",filter);
	}
	
	public int OverlabNickname(AccountFilter filter){
		
		return (int)selectOne("Auth.overlabNickname",filter);
	}
}
