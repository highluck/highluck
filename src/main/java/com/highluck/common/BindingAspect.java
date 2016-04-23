package com.highluck.common;

import java.lang.annotation.Target;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Aspect
public class BindingAspect {
	protected Log log = LogFactory.getLog(BindingAspect.class);
	
	@Around("execution(* com.highluck.service.*Service.*(..))")
	public Object binding(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object target = joinPoint.getTarget(); 		
		            
	    Field[] arrField = target.getClass().getFields();
		
	    for (Object obj : joinPoint.getArgs()) {
            if (obj instanceof HttpServletRequest || obj instanceof MultipartHttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) obj;
            	
        		for (int i = 0; i < arrField.length; i++) {
        			Field field = arrField[i];
        		   			
				try {						
					if(field.getType() == int.class){
						field.set(Target.class, Integer.parseInt(request.getParameter(field.getName()))); 
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
	   }		 
		 return joinPoint.proceed();
	 }
}

