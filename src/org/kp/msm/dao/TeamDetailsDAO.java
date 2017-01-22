package org.kp.msm.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.kp.msm.entity.TeamDetails;

public class TeamDetailsDAO {
	
	public boolean addTeamMember(String leadId, String memberId)
	{
		Session session = null;
		boolean add = false;
		TeamDetails teamDetails = new TeamDetails();
		try{
			teamDetails.setLeadId(leadId.toUpperCase());
			teamDetails.setMemberId(memberId.toUpperCase());
			teamDetails.setEntryId(leadId.toUpperCase());
			teamDetails.setEntryTs(new Date());
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			session.save(teamDetails);
			add = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in addTeamMember Details");
			add = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return add;
	}
	
	public boolean deleteTeamMember(String Id)
	{
		Session session = null;
		boolean delete = false;
		TeamDetails teamDetails = null;
		try{
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			teamDetails = session.get(TeamDetails.class, Integer.parseInt(Id));
			session.delete(teamDetails);
			delete = true;
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in deleteTeamMember");
			delete = false;
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return delete;
	}

	public ArrayList<TeamDetails> getTeam(String leadId)
	{
		Session session = null;
		ArrayList<TeamDetails> teamList = null;
		try{
			teamList = new ArrayList<TeamDetails>();
			session = HibernateUtil.getSessionFactoryInstance().openSession();
			session.beginTransaction();
			Criteria cc = session.createCriteria(TeamDetails.class); 
			cc.add(Restrictions.eq("leadId", leadId));
			teamList = (ArrayList<TeamDetails>) cc.list();
			session.getTransaction().commit();
	}
		catch(Exception ex)
		{
			System.out.println("Exception occured in getTeam");
			ex.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.close();
		}
		return teamList;
	}


}
