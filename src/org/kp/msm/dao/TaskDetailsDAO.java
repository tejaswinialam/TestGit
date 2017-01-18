package org.kp.msm.dao;

import java.util.Date;

import org.hibernate.Session;
import org.kp.msm.entity.TaskDetails;

public class TaskDetailsDAO {
	
	public boolean addTaskDetails(String TaskId, String AppName, String Description, String Type, String Category,
			String EntryId)
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

}
