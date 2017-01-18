package org.kp.msm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.READER;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.kp.msm.entity.MSMActivityLog;

public class MSMActivityLogDAO {
	
	public boolean addMSMActivity(String TaskId, String UserId, String Month, int Hours,
			String DetailedDesc, String EntryId)
	{
		Session session = null;
		boolean add = false;
		MSMActivityLog activity = new MSMActivityLog();
		try{
			activity.setTaskId(TaskId);
			activity.setUserId(UserId);
			activity.setMonth(Month);
			activity.setHours(Hours);
			activity.setDetailedDesc(DetailedDesc);
			activity.setEntryId(EntryId);
			activity.setEntryTimeStamp(new Date());
			activity.setUpdateFlag("A");
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			session.save(activity);
			add = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in addMSMActivity");
			add = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return add;
	}
	
	public boolean updateMSMActivityLog(long Id, int hours, String updateFlag, String updtId)
	{
		Session session = null;
		boolean add = false;
		MSMActivityLog activity = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			activity = session.get(MSMActivityLog.class, Id);
			if(updateFlag.equals("E"))
			activity.setHours(hours);
			
			activity.setUpdateFlag(updateFlag);
			activity.setUpdateId(updtId);
			activity.setUpdateTimeStamp(new Date());
			session.update(activity);
			add = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in updateMSMActivityLog");
			add = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return add;
		
	}
	
	public ArrayList<MSMActivityLog> getEffortForTask(String entryId, String Month)
	{
		ArrayList<MSMActivityLog> list = new ArrayList<MSMActivityLog>();
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			Criteria cc = session.createCriteria(MSMActivityLog.class); 
			cc.add(Restrictions.in("UpdateFlag", new String[] {"A","E"}));
			cc.add(Restrictions.eq("EntryId", entryId));
			cc.add(Restrictions.eq("Month", Month));
			
			list = (ArrayList<MSMActivityLog>) cc.list();
			session.getTransaction().commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Exception occured in getEffortForTask");
			}
			finally
			{
				if(session != null)
					session.close();
			}
		return list;
			
		}

}
