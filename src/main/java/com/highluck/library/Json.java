package com.highluck.library;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
	private static Json json = new Json();
	private Json(){}
	public static Json JsonSerialize(){
		return json;
	}
	
	public void ReturnJSON(HttpServletResponse response, Object objReturn){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonReturn = gson.toJson(objReturn);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonReturn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
