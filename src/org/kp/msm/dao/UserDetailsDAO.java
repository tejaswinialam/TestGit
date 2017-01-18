package org.kp.msm.dao;

import java.util.Date;

import org.hibernate.Session;
import org.kp.msm.entity.UserDetails;

public class UserDetailsDAO {

	public boolean addUser(String UserId, String password, String email, String FirstName, String LastName,
			String isAdmin, String entryId)
	{
		Session session = null;
		boolean add = false;
		UserDetails userDetails = new UserDetails();
		try{
			userDetails.setUserId(UserId.toUpperCase());
			userDetails.setPassword(password);
			userDetails.setEmail(email);
			userDetails.setFirstName(FirstName);
			userDetails.setLastName(LastName);
			userDetails.setAdmin(isAdmin);
			userDetails.setEntryId(entryId);
			userDetails.setEntryTimeStamp(new Date());
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			session.save(userDetails);
			add = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in addUser Details");
			add = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return add;
	}
	
	public UserDetails getUserDetails(String userId)
	{
		Session session = null;
		UserDetails userDetails = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			userDetails = session.get(UserDetails.class, userId);
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Exception occured in getUserDetails");
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return userDetails;
	}
	
	public boolean updateUserDetails(String userId, String password)
	{
		Session session = null;
		boolean update = false;
		UserDetails userDetails = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			userDetails = session.get(UserDetails.class, userId);
			userDetails.setPassword(password);
			update = true;
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Exception occured in updateUserDetails");
			update = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return update;
	}
	

}
