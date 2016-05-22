package com.peoplejob.biz;

import com.peoplejob.dao.AuthDAO;
import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.dto.response.CommonResponse;

public class AuthBiz {

	private AuthDAO authDao;

	public void setAuthDao(AuthDAO authDao) {
		this.authDao = authDao;
	}
	
	public CommonResponse OverlabEmail(AccountFilter filter){
		CommonResponse response = new CommonResponse();
		int result = authDao.OverlabEmail(filter);
		if(result > 0){
			response.setResult("true");
		}
		else{			
			response.setResult("false");
		}		
		return response;
	}
	
	public CommonResponse OverlabNickname(AccountFilter filter){
		CommonResponse response = new CommonResponse();
		int result = authDao.OverlabNickname(filter);
		if(result > 0){
			response.setResult("true");
		}
		else{			
			response.setResult("false");
		}		
		return response;
	}	

}
