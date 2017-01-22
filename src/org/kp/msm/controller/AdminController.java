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
import org.kp.msm.dao.TeamDetailsDAO;
import org.kp.msm.dao.UserDetailsDAO;
import org.kp.msm.entity.MSMActivityLog;
import org.kp.msm.entity.TeamDetails;
import org.kp.msm.entity.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView redirectToLogin(HttpServletRequest request, HttpSession session)
	{
		LoginBean loginBean = (LoginBean)request.getSession().getAttribute("user");
		if(loginBean != null)
		{
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("loginbean",  loginBean);
		return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("errorMessage", "Session Expired Please login again");
			return mav;
		}
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
		UserDetails userDetails = tdao.getUserDetails(username.toUpperCase());
		 if(userDetails!=null)
			 loginBean = MSMUtil.getLoginBean(userDetails);
		 return loginBean;
	}
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public @ResponseBody boolean updateUserInDB(@RequestBody LoginBean loginbean,HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		UserDetailsDAO tdao = new UserDetailsDAO();
		boolean update = tdao.updateUserDetails(loginbean.getUsername().toUpperCase()
				,loginbean.getPassword(),loginbean.getEmail(),loginbean.getFirstName(),loginbean.getLastName(),loginbean.getIsAdmin(),userId);
		return update;
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public @ResponseBody boolean addUserToDB(@RequestBody LoginBean loginbean,HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		UserDetailsDAO tdao = new UserDetailsDAO();
		boolean add = tdao.addUser(loginbean.getUsername(),loginbean.getPassword(),loginbean.getEmail(),loginbean.getFirstName(),loginbean.getLastName(),loginbean.getIsAdmin(),userId);
		return add;
	}
	
	@RequestMapping(value="/deleteUser/{userId}", method=RequestMethod.GET)
	public @ResponseBody boolean deleteUser(@PathVariable("userId") String username,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		System.out.println("userId from UI :"+username);
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		UserDetailsDAO tdao = new UserDetailsDAO();
		boolean delete = tdao.deleteUserDetails(username.toUpperCase(), userId);
		 return delete;
	}
	
	@RequestMapping(value="/getEffortUser/{userId}", method=RequestMethod.GET)
	public @ResponseBody ArrayList<HistoryBean> getEffortFromDB(@PathVariable("userId") String username,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		System.out.println("userId from UI :"+username);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String month = sdf.format(new Date());
		System.out.println(month);
		MSMActivityLogDAO dao = new MSMActivityLogDAO();
		ArrayList<MSMActivityLog> list = dao.getEffortForTasks(username.toUpperCase(), month);
		ArrayList<HistoryBean> h = MSMUtil.getListofActivity(list);
		return h;
	}
	
	@RequestMapping(value="/getEffortTask/{taskId}", method=RequestMethod.GET)
	public @ResponseBody ArrayList<HistoryBean> getEffortForTask(@PathVariable("taskId") String taskId,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		//System.out.println("userId from UI :"+username);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String month = sdf.format(new Date());
		System.out.println(month);
		MSMActivityLogDAO dao = new MSMActivityLogDAO();
		ArrayList<MSMActivityLog> list = dao.getEffortForSingleTask(taskId, month);
		ArrayList<HistoryBean> h = MSMUtil.getListofActivity(list);
		return h;
	}
	
	@RequestMapping(value="/getTeamEffort", method=RequestMethod.GET)
	public @ResponseBody ArrayList<HistoryBean> getTeamEffort(HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		//System.out.println("userId from UI :"+username);
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String month = sdf.format(new Date());
		System.out.println(month);
		MSMActivityLogDAO dao = new MSMActivityLogDAO();
		ArrayList<MSMActivityLog> list = dao.getEffortForTeam(userId, month);
		ArrayList<HistoryBean> h = MSMUtil.getListofActivity(list);
		return h;
	}
	
	@RequestMapping(value="/deleteMember/{memberId}", method=RequestMethod.GET)
	public @ResponseBody boolean deleteMember(@PathVariable("memberId") String memberId,
			HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		System.out.println("userId from UI :"+memberId);
		TeamDetailsDAO dao = new TeamDetailsDAO();
		boolean delete = dao.deleteTeamMember(memberId);
		return delete;
	}
	
	@RequestMapping(value="/getTeamDetails", method=RequestMethod.GET)
	public @ResponseBody ArrayList<LoginBean> getTeamDetails(HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		//System.out.println("userId from UI :"+username);
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		String month = sdf.format(new Date());
		System.out.println(month);
		TeamDetailsDAO dao = new TeamDetailsDAO();
		ArrayList<TeamDetails> list = dao.getTeam(userId.toUpperCase());
		ArrayList<LoginBean> h = MSMUtil.getLoginBeanList(list);
		return h;
	}
	
	@RequestMapping(value="/addMember/{memberId}", method=RequestMethod.GET)
	public @ResponseBody boolean getTeamEffort(@PathVariable("memberId") String memberId,HttpServletRequest request, HttpSession session)
	{
		System.out.println(request.getSession().getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		//System.out.println("userId from UI :"+username);
		String userId = MSMUtil.getUserId((LoginBean)request.getSession().getAttribute("user"));
		boolean add = false;
		TeamDetailsDAO dao = new TeamDetailsDAO();
		UserDetailsDAO uDao = new UserDetailsDAO();
		UserDetails userDetail = uDao.getUserDetails(memberId);
		if(userDetail != null){
			add = dao.addTeamMember(userId.toUpperCase(), memberId.toUpperCase());
		}
		return add;
	}
	

}
