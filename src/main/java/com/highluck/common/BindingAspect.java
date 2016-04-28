package com.highluck.common;

import java.lang.annotation.Target;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Aspect
public class BindingAspect extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(BindingAspect.class);
	static HttpServletRequest request;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.request = request;
        System.out.println(request);
        return super.preHandle(request, response, handler);
    }
	
		
	@Before("execution(* com.highluck.Service.*Service.*(..))")
	public void binding(JoinPoint joinPoint) throws Throwable{
		Object target = joinPoint.getTarget(); 		
		//HttpServletRequest requests =  (HttpServletRequest)joinPoint.getArgs();
	    Field[] arrField = target.getClass().getFields();
	    if(request.getParameterNames() != null){
	     
		 		for (int i = 0; i < arrField.length; i++) {
        			Field field = arrField[i];
        			System.out.println(field.getType()+ " == " +int.class);
				try {						
					if(field.getType() == int.class){
						System.out.println("asdasd :" +request.getParameter(field.getName()));
						field.set(joinPoint.getThis(), Integer.parseInt(request.getParameter(field.getName()))); 
					} else if(field.getType() == double.class){
						field.set(Target.class, Double.parseDouble(request.getParameter(field.getName())));
					} else{
						field.set(Target.class, request.getParameter(field.getName()));
					}
					log.debug(field);
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					continue;
				}
        	}	  
		}
		 request = null;
	 }
}

