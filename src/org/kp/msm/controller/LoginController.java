package org.kp.msm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kp.msm.bean.LoginBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/Login", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginBean validateLogin(@RequestBody LoginBean loginbean, HttpServletRequest request, HttpSession session)
	{
		System.out.println("Entered into this request");

		//Get from Database
		String username = "S123788";
		String password = "S123788";
		
		System.out.println(loginbean.getUsername());
		System.out.println(loginbean.getPassword());
		if(username.equalsIgnoreCase(loginbean.getUsername()) && password.equalsIgnoreCase(loginbean.getPassword()))
		{
			System.out.println("Authenticated");
			loginbean.setAuth(true);
		}
		else
		{
			System.out.println("not Authenticated");
			loginbean.setAuth(false);
		}
		return loginbean;
	}
	
	@RequestMapping(value="/msmfill", method=RequestMethod.GET)
	public String goToMsmLogin(HttpServletRequest request, HttpSession session)
	{
		return "msmfill";
	}
}
