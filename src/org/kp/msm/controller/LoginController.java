package org.kp.msm.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kp.msm.bean.ApplicationBean;
import org.kp.msm.bean.HistoryBean;
import org.kp.msm.bean.LoginBean;
import org.kp.msm.bean.ResponseBean;
import org.kp.test.TestClass;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
/*@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
maxFileSize=1024*1024*50,          // 50 MB
maxRequestSize=1024*1024*100)**/
public class LoginController {
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	//public @ResponseBody LoginBean validateLogin(@RequestBody LoginBean loginbean, HttpServletRequest request, HttpSession session)
	public ModelAndView validateLogin(@ModelAttribute LoginBean loginbean, HttpServletRequest request, HttpSession session)
	{
		System.out.println("Entered into this request");

		//Get from Database
		String username = "S123788";
		String password = "S123788";
		loginbean.setName("Tejaswini Alamuri");
		loginbean.setSessionStartTime(new Date());
		System.out.println(loginbean.getUsername());
		System.out.println(loginbean.getPassword());
		if(username.equalsIgnoreCase(loginbean.getUsername()) && password.equalsIgnoreCase(loginbean.getPassword()))
		{
			System.out.println("Authenticated");
			ModelAndView mav = new ModelAndView("msmfill");
			System.out.println("Setting the view to msmfill");
			loginbean.setAuth(true);
			mav.addObject("loginbean", loginbean);
			session.setAttribute("user", loginbean);
			return mav;
		}
		else
		{
			System.out.println("not Authenticated");
			ModelAndView mav1 = new ModelAndView("login");
			System.out.println("Setting the view to login");
			loginbean.setAuth(false);
			mav1.addObject("loginbean", loginbean);
			mav1.addObject("errorMessage", "Invalid Username or Password. Please try again");
			return mav1;
		}
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public ModelAndView redirectToLogin()
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("errorMessage", "Session Expired Please login again");
		return mav;
	}
	
	/*@RequestMapping(value="/msmfill", method=RequestMethod.GET)
	public String goToMsmLogin(HttpServletRequest request, HttpSession session)
	{
		System.out.println(session.getAttribute("user"));
		return "msmfill";
	}*/
	
	@RequestMapping(value="/getAppsList", method=RequestMethod.GET)
	public @ResponseBody ArrayList<ApplicationBean> getAppsList(HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		Properties prop = new Properties();
		InputStream input = null;
		ArrayList<ApplicationBean> li=new ArrayList<ApplicationBean>();
		try {

			//input = new FileInputStream("a.properties");

			// load a properties file
			prop.load(getClass().getResourceAsStream("a.properties"));
			
			String list[]=prop.getProperty("APPS").split(",");
			List<String> strList = Arrays.asList(list);
		
			System.out.println(strList.size());
			ApplicationBean bean;
			for(int i=0; i<strList.size();i++)
			{
				bean=new ApplicationBean();
				bean.setAppName(strList.get(i));
				li.add(bean);
				
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Exception occured : "+fnfe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured : "+e);
		}
		return li;
		
	}
	
	@RequestMapping(value="/load/{appname}/{category}", method=RequestMethod.GET)
	public @ResponseBody ResponseBean loadFromDatabase(@PathVariable("appname") String appname,@PathVariable("category") String category,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		System.out.println("appname from UI :"+appname);
		System.out.println("Category from UI :"+category);
		 ArrayList<ApplicationBean> l = TestClass.getTestData(category);
		 ArrayList<HistoryBean> h = TestClass.getTestData1(category);
		 request.getSession().getAttribute("user");
		 
		 
		 ResponseBean jrb = new ResponseBean();
		 jrb.setBeanList(l);
		 jrb.setHistoryBeanList(h);
		 
		 return jrb;
	}
	
	@RequestMapping(value="/getCatfromWS/{appname}/{category}", method=RequestMethod.GET)
	public @ResponseBody ArrayList<ApplicationBean> getCategoryListFromWS(@PathVariable("appname") String appname,@PathVariable("category") String category,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println("appname from UI :"+appname);
		System.out.println("Category from UI :"+category);
		System.out.println(session.getAttribute("user"));
		 ArrayList<ApplicationBean> l = TestClass.getTestData(category);
		 //ArrayList<HistoryBean> h = TestClass.getTestData1(category);
		 //ResponseBean jrb = new ResponseBean();
		// jrb.setBeanList(l);
		// jrb.setHistoryBeanList(h);
		 
		 return l;
	}
	
	@RequestMapping(value="/addEfforts" ,method=RequestMethod.POST)
	public @ResponseBody boolean addEfforts(@RequestBody HistoryBean historyBean,HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		LoginBean user = (LoginBean) session.getAttribute("user");
		if(user == null)
		{
			System.out.println(user.getSessionStartTime());
			session.invalidate();
		}
		System.out.println(session.getAttribute("user"));
		System.out.println(historyBean);
		if(historyBean != null)
		{
			System.out.println(historyBean.getCatNumber());
			System.out.println(historyBean.getCategory());
			System.out.println(historyBean.getEffort());
			System.out.println(historyBean.getUpdateFlag());
			System.out.println(historyBean.getAdhocComments());
			System.out.println();
		}
		return true;
	}
	
	@RequestMapping(value="/logout" ,method=RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpSession session)
	{
		System.out.println("Logging out from the System");
		System.out.println(request.getSession().getAttribute("user"));
		LoginBean user = (LoginBean) session.getAttribute("user");
		System.out.println("Session Start Time : "+user.getSessionStartTime());
		session.invalidate();
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("errorMessage", "Successfully Logged Out");
		return mav;
	}
	
	
}
