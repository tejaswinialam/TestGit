package org.kp.msm.dao;

import java.util.ArrayList;

import org.kp.msm.bean.ApplicationBean;
import org.kp.msm.bean.HistoryBean;
import org.kp.msm.bean.LoginBean;
import org.kp.msm.entity.MSMActivityLog;
import org.kp.msm.entity.TaskDetails;
import org.kp.msm.entity.TeamDetails;
import org.kp.msm.entity.UserDetails;

public class MSMUtil {
	
	public static ArrayList<ApplicationBean> getListofTask(ArrayList<TaskDetails> taskList)
	{
		ArrayList<ApplicationBean> beanList = null;
		try
		{
			beanList = new ArrayList<ApplicationBean>();
			for(TaskDetails task : taskList)
			{
				ApplicationBean bean = new ApplicationBean();
				bean.setCatNumber(task.getTaskId());
				bean.setAppName(task.getApplicationName());
				bean.setDescription(task.getDescription());
				bean.setTaskId(task.getTaskId());
				beanList.add(bean);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured in getListofTasks: "+ex);
			ex.printStackTrace();
		}
		return beanList;
		
	}
	
	public static ArrayList<HistoryBean> getListofActivity(ArrayList<MSMActivityLog> activityList)
	{
		ArrayList<HistoryBean> beanList = null;
		try
		{
			TaskDetailsDAO tdao = new TaskDetailsDAO();
			beanList = new ArrayList<HistoryBean>();
			for(MSMActivityLog activity : activityList)
			{
				TaskDetails taskDetail = tdao.getTaskDetail(activity.getTaskId());
				HistoryBean bean = new HistoryBean();
				bean.setCatNumber(activity.getTaskId());
				bean.setCategory(taskDetail.getCategory());
				bean.setDecription(taskDetail.getDescription());
				bean.setEffort(new Integer(activity.getHours()).toString());
				bean.setTaskId(new Long(activity.getId()).toString());
				bean.setEntryId(activity.getEntryId());
				beanList.add(bean);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured in getListofTasks: "+ex);
			ex.printStackTrace();
		}
		return beanList;
		
	}
	
	public static String getUserId(LoginBean loginBean)
	{
		if(loginBean != null)
			return loginBean.getUsername();
		else
			return null;
	}
	
	public static LoginBean getLoginBean(UserDetails user)
	{
		LoginBean loginbean = new LoginBean();
		loginbean.setUsername(user.getUserId());
		loginbean.setPassword(user.getPassword());
		loginbean.setEmail(user.getEmail());
		loginbean.setFirstName(user.getFirstName());
		loginbean.setLastName(user.getLastName());
		loginbean.setIsAdmin(user.getAdmin());
		return loginbean;
	}
	
	public static UserDetails getLoginBean(LoginBean loginbean)
	{
		UserDetails user = new UserDetails();
		user.setUserId(loginbean.getUsername());
		user.setPassword(loginbean.getPassword());
		user.setEmail(loginbean.getEmail());
		user.setFirstName(loginbean.getFirstName());
		user.setLastName(loginbean.getLastName());
		user.setAdmin(loginbean.getIsAdmin());
		return user;
	}
	
	public static ArrayList<LoginBean> getLoginBeanList(ArrayList<TeamDetails> teamList)
	{
		ArrayList<LoginBean> beanList = null;
		try
		{
			UserDetailsDAO tdao = new UserDetailsDAO();
			beanList = new ArrayList<LoginBean>();
			for(TeamDetails activity : teamList)
			{
				UserDetails userDetail = tdao.getUserDetails(activity.getMemberId());
				if(userDetail != null)
				{
				LoginBean bean = new LoginBean();
				bean.setName((userDetail.getFirstName()==null ? "" :userDetail.getFirstName())+" "+(userDetail.getLastName()==null ? "" :userDetail.getLastName()));
				bean.setUsername(activity.getMemberId());
				bean.setId(activity.getId());
				beanList.add(bean);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured in getListofTasks: "+ex);
			ex.printStackTrace();
		}
		return beanList;
	}
}
