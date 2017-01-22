package org.kp.msm.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.kp.msm.entity.MSMActivityLog;
import org.kp.msm.entity.TaskDetails;

public class TaskDetailsDAO {
	
	public boolean addTaskDetails(String TaskId, String AppName, String Description, String Type, String Category,
			String assignee, String EntryId)
	{
		Session session = null;
		boolean add = false;
		TaskDetails td = new TaskDetails();
		try{
			td.setTaskId(TaskId);
			td.setApplicationName(AppName);
			td.setDescription(Description);
			td.setType(Type);
			td.setCategory(Category);
			td.setAssignee(assignee);
			td.setEntryId(EntryId);
			td.setEntryTimeStamp(new Date());
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			session.save(td);
			add = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in addTaskDetails");
			add = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return add;
	}
	
	public ArrayList<TaskDetails> getTasks(String category, String appName)
	{
		ArrayList<TaskDetails> list = new ArrayList<TaskDetails>();
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			Criteria cc = session.createCriteria(TaskDetails.class); 
			cc.add(Restrictions.eq("category", category));
			cc.add(Restrictions.eq("ApplicationName", appName));
			list = (ArrayList<TaskDetails>) cc.list();
			session.getTransaction().commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Exception occured in getTasks");
			}
			finally
			{
				if(session != null)
					session.close();
			}
		return list;
			
		}
	
	public TaskDetails getTaskDetail(String taskId)
	{
		TaskDetails list = new TaskDetails();
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			list = session.get(TaskDetails.class, taskId);
			session.getTransaction().commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Exception occured in getTaskDetail");
			}
			finally
			{
				if(session != null)
					session.close();
			}
		return list;
			
		}

}
