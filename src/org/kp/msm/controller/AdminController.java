package org.kp.msm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kp.msm.bean.ApplicationBean;
import org.kp.msm.bean.HistoryBean;
import org.kp.msm.bean.LoginBean;
import org.kp.msm.bean.ResponseBean;
import org.kp.msm.dao.MSMActivityLogDAO;
import org.kp.msm.dao.MSMUtil;
import org.kp.msm.dao.TaskDetailsDAO;
import org.kp.msm.dao.UserDetailsDAO;
import org.kp.msm.entity.MSMActivityLog;
import org.kp.msm.entity.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView redirectToLogin(HttpServletRequest request, HttpSession session)
	{
		LoginBean loginBean = new LoginBean();
		loginBean.setName("Tejaswini Alamuri");
		loginBean.setUsername("S123788");
		loginBean.setPassword("S123788");
		loginBean.setIsAdmin("Y");
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("loginbean",  loginBean);
		session.setAttribute("user", loginBean);
		return mav;
	}
	
	@RequestMapping(value="/findUser/{userId}", method=RequestMethod.GET)
	public @ResponseBody LoginBean getUserFromDB(@PathVariable("userId") String username,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		System.out.println("userId from UI :"+username);
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		LoginBean loginBean = null;
		UserDetailsDAO tdao = new UserDetailsDAO();
		UserDetails userDetails = tdao.getUserDetails(username);
		 if(userDetails!=null)
			 loginBean = MSMUtil.getLoginBean(userDetails);
		 return loginBean;
	}
	
	

}
