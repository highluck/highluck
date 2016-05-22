package com.peoplejob.dto.response;

import com.peoplejob.dto.account.Account;

public class LoginResponse {

	private String reason;
	private String result;
	private String token;
	private Account account;

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String e) {
		this.reason = e;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
