package org.kp.msm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kp.msm.exception.LoginFailException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		String path = request.getRequestURI().substring(request.getContextPath().length());

        if(path.equals("/Login")){
        	System.out.println("Login Request");
            return true;
        }
        else if(session == null || session.getAttribute("user") == null) {
            System.out.println("User is failed");
        	request.setAttribute("emassage", "login failed");                
            throw new LoginFailException("login failed");                
        }else{ 
        	System.out.println("As usual FLow");
            return true;
        }  
	}

}
