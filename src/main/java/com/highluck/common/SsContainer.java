package com.highluck.common;

import org.springframework.web.servlet.ModelAndView;

import com.highluck.ServiceStack.JsonReturn;

public class SsContainer {
	
	private JsonReturn json;

	public JsonReturn getJson() {
		return json;
	}

	public void setJson(JsonReturn json) {
		this.json = json;
	}
}
