package org.kp.test;

import java.util.ArrayList;

import org.kp.msm.bean.ApplicationBean;
import org.kp.msm.bean.HistoryBean;
import org.kp.msm.dao.MSMActivityLogDAO;
import org.kp.msm.dao.TaskDetailsDAO;
import org.kp.msm.dao.TeamDetailsDAO;
import org.kp.msm.dao.UserDetailsDAO;
import org.kp.msm.entity.MSMActivityLog;



public class TestClass {
	public static ArrayList<ApplicationBean> getTestData(String category)
	{
		ArrayList<ApplicationBean> li=new ArrayList<ApplicationBean>();
		if(category.equals("Work Order"))
		{
			ApplicationBean b1= new ApplicationBean();
		b1.setCatNumber("WO0000003351016");
		b1.setDescription("080 - Careteams - Provider Substitution Issue - analysis");
		
		ApplicationBean b2= new ApplicationBean();
		b2.setCatNumber("WO0000004445817");
		b2.setDescription("010 CAD - Core Projects PLMS Process Improvements. PLMS - Health Check Automation");
		
		ApplicationBean b3= new ApplicationBean();
		b3.setCatNumber("WO0000004445823");
		b3.setDescription("010 CAD - Core Projects PLMS Process Improvements. Implementing JPA in NPLMS ");
		
		ApplicationBean b4= new ApplicationBean();
		b4.setCatNumber("WO0000004446101");
		b4.setDescription("Core Projects PLMS Process Improvements. xPression batch Job's XML clean up in plms-xp");
		li.add(b1);
		li.add(b2);
		li.add(b3);
		li.add(b4);
			}
		else if(category.equals("Task"))
		{
			ApplicationBean b1= new ApplicationBean();
		b1.setCatNumber("TAS0000003351016");
		b1.setDescription("PLMS XP Upgrade and Cloud Migration.");
		
		ApplicationBean b2= new ApplicationBean();
		b2.setCatNumber("TAS0000004445817");
		b2.setDescription("KPHC user is unable to change end date for Care Team");
		
		ApplicationBean b3= new ApplicationBean();
		b3.setCatNumber("TAS0000004445823");
		b3.setDescription("eConsult Not Launching");
		
		ApplicationBean b4= new ApplicationBean();
		b4.setCatNumber("TAS0000004446101");
		b4.setDescription("100 - PLMS PCP Assignment Letters");
		li.add(b1);
		li.add(b2);
		li.add(b3);
		li.add(b4);
		}else if(category.equals("Incident"))
		{
			ApplicationBean b1= new ApplicationBean();
		b1.setCatNumber("INC0000003351016");
		b1.setDescription("**Urgent** Unable to login to eConsult from KPHC");
		
		ApplicationBean b2= new ApplicationBean();
		b2.setCatNumber("INC0000004445817");
		b2.setDescription("50 CAD -Appl Knowledge Sharing");
		
		ApplicationBean b3= new ApplicationBean();
		b3.setCatNumber("INC0000004445823");
		b3.setDescription("100 CAD Covered CA Phase 3");
		
		ApplicationBean b4= new ApplicationBean();
		b4.setCatNumber("INC0000004446101");
		b4.setDescription("110 CAD - Pre-Project Activities - 2015 MAS");
		li.add(b1);
		li.add(b2);
		li.add(b3);
		li.add(b4);
		}
		else if(category.equals("Change Request"))
		{
			ApplicationBean b1= new ApplicationBean();
		b1.setCatNumber("CRQ0000003351016");
		b1.setDescription("PLMS XP - Consult For Upgrading MS SQL server");
		
		ApplicationBean b2= new ApplicationBean();
		b2.setCatNumber("CRQ0000004445817");
		b2.setDescription("QECNR123 - Abend analysis and followup");
		
		ApplicationBean b3= new ApplicationBean();
		b3.setCatNumber("CRQ0000004445823");
		b3.setDescription("Modify VPN Access for PACTS Support Team");
		
		ApplicationBean b4= new ApplicationBean();
		b4.setCatNumber("CRQ0000004446101");
		b4.setDescription("110 CAD - Pre-Project Activities - KPATHS");
		li.add(b1);
		li.add(b2);
		li.add(b3);
		li.add(b4);
		
		}
		return li;
	}

	
	public static ArrayList<HistoryBean> getTestData1(String category)
	{
		ArrayList<HistoryBean> li=new ArrayList<HistoryBean>();
		if(category.equals("Work Order"))
		{
		HistoryBean hb1 = new HistoryBean();
		hb1.setCatNumber("WO0000003351016");
		hb1.setDecription("080 - Careteams - Provider Substitution Issue - analysis");
		hb1.setCategory(category);
		hb1.setEffort("16");
		hb1.setType("010");
		
		HistoryBean hb2 = new HistoryBean();
		hb2.setCatNumber("WO0000004445817");
		hb2.setDecription("010 CAD - Core Projects PLMS Process Improvements. PLMS - Health Check Automation");
		hb2.setCategory(category);
		hb2.setEffort("36");
		hb2.setType("100");
	
		HistoryBean hb3 = new HistoryBean();
		hb3.setCatNumber("WO0000004445823");
		hb3.setDecription("010 CAD - Core Projects PLMS Process Improvements. Implementing JPA in NPLMS ");
		hb3.setCategory(category);
		hb3.setEffort("78");
		hb3.setType("010");
		
		li.add(hb1);
		li.add(hb2);
		li.add(hb3);
		}
		else if(category.equals("Task"))
		{
		HistoryBean hb1 = new HistoryBean();
		hb1.setCatNumber("TAS0000004445817");
		hb1.setDecription("KPHC user is unable to change end date for Care Team");
		hb1.setCategory(category);
		hb1.setEffort("16");
		hb1.setType("010");
		
		HistoryBean hb2 = new HistoryBean();
		hb2.setCatNumber("TAS0000004445823");
		hb2.setDecription("eConsult Not Launching");
		hb2.setCategory(category);
		hb2.setEffort("36");
		hb2.setType("100");
	
		HistoryBean hb3 = new HistoryBean();
		hb3.setCatNumber("TAS0000004446101");
		hb3.setDecription("100 - PLMS PCP Assignment Letters");
		hb3.setCategory(category);
		hb3.setEffort("78");
		hb3.setType("010");
		
		li.add(hb1);
		li.add(hb2);
		li.add(hb3);
		}else if(category.equals("Incident"))
		{
		HistoryBean hb1 = new HistoryBean();
		hb1.setCatNumber("INC0000004445817");
		hb1.setDecription("50 CAD -Appl Knowledge Sharing");
		hb1.setCategory(category);
		hb1.setEffort("16");
		hb1.setType("010");
		
		HistoryBean hb2 = new HistoryBean();
		hb2.setCatNumber("INC0000004445823");
		hb2.setDecription("100 CAD Covered CA Phase 3");
		hb2.setCategory(category);
		hb2.setEffort("36");
		hb2.setType("100");
	
		HistoryBean hb3 = new HistoryBean();
		hb3.setCatNumber("INC0000004446101");
		hb3.setDecription("110 CAD - Pre-Project Activities - 2015 MAS");
		hb3.setCategory(category);
		hb3.setEffort("78");
		hb3.setType("010");
		
		li.add(hb1);
		li.add(hb2);
		li.add(hb3);
		}
		else if(category.equals("Change Request"))
		{
		HistoryBean hb1 = new HistoryBean();
		hb1.setCatNumber("CRQ0000004445817");
		hb1.setDecription("QECNR123 - Abend analysis and followup");
		hb1.setCategory(category);
		hb1.setEffort("16");
		hb1.setType("010");
		
		HistoryBean hb2 = new HistoryBean();
		hb2.setCatNumber("CRQ0000004445823");
		hb2.setDecription("Modify VPN Access for PACTS Support Team");
		hb2.setCategory(category);
		hb2.setEffort("36");
		hb2.setType("100");
	
		HistoryBean hb3 = new HistoryBean();
		hb3.setCatNumber("CRQ0000004446101");
		hb3.setDecription("110 CAD - Pre-Project Activities - KPATHS");
		hb3.setCategory(category);
		hb3.setEffort("78");
		hb3.setType("010");
		
		li.add(hb1);
		li.add(hb2);
		li.add(hb3);
		}
		return li;
	}
	
	public static void main(String args[])
	{
		UserDetailsDAO ud = new UserDetailsDAO();
		ud.addUser("S123788", "S123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", true, "S123788");
		ud.addUser("A123788", "A123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", true, "S123788");
		ud.addUser("B123788", "B123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", false, "S123788");
		ud.addUser("C123788", "C123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", false, "S123788");
		ud.addUser("D123788", "D123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", false, "S123788");
		ud.addUser("E123788", "E123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", false, "S123788");
		ud.addUser("F123788", "F123788", "tejaswini.alamuri@kp.org", "Tejaswini", "Alamuri", false, "S123788");
		TaskDetailsDAO td = new TaskDetailsDAO();
		td.addTaskDetails("CRQ0000004446101", "AD CDA PACTS SUP", "Modify VPN Access for PACTS Support Team",
				"010", "Change Request", "Tejaswini Alamuri", "S123788");
		td.addTaskDetails("CRQ0000004445823", "AD CDA PACTS SUP", "Modify VPN Access for PACTS Support Team",
				"010", "Change Request", "Tejaswini Alamuri", "S123788");
		td.addTaskDetails("CRQ0000004445817", "AD CDA ECONSULT", "QECNR123 - Abend analysis and followup",
				"010", "Change Request", "Tejaswini Alamuri","S123788");
		td.addTaskDetails("CRQ0000003351016", "AD CDA PLMS", "PLMS XP - Consult For Upgrading MS SQL server",
				null, "Change Request", "Tejaswini Alamuri","S123788");
		//WO
		td.addTaskDetails("WO0000003351016", "AD CDA CARETEAMS", "080 - Careteams - Provider Substitution Issue - analysis",
				"080", "Work Order","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("WO0000004445817", "AD CDA PLMS", "010 CAD - Core Projects PLMS Process Improvements. PLMS - Health Check Automation",
				"010", "Work Order","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("WO0000004445823", "AD CDA PLMS", "010 CAD - Core Projects PLMS Process Improvements. Implementing JPA in NPLMS ",
				"010", "Work Order","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("WO0000004446101", "AD CDA PLMS", "Core Projects PLMS Process Improvements. xPression batch Job's XML clean up in plms-xp",
				"010", "Work Order","Tejaswini Alamuri", "S123788");
		//TASK
		td.addTaskDetails("TAS0000003351016", "AD CDA PLMS", "PLMS XP Upgrade and Cloud Migration.",
				null, "Task", "Tejaswini Alamuri","S123788");
		td.addTaskDetails("TAS0000004445817", "AD CDA ECONSULT", "KPHC user is unable to change end date for Care Team",
				null, "Task","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("TAS0000004445823", "AD CDA ECONSULT", "eConsult Not Launching",
				null, "Task","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("TAS0000004446101", "AD CDA PLMS", "100 - PLMS PCP Assignment Letters",
				null, "Task", "Tejaswini Alamuri","S123788");
		
		//INC
		td.addTaskDetails("INC0000003351016", "AD CDA ECONSULT", "**Urgent** Unable to login to eConsult from KPHC",
				null, "Incident","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("INC0000004445817", "AD CDA PACTS SUP", "50 CAD -Appl Knowledge Sharing",
				null, "Incident","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("INC0000004445823", "AD CDA MOSL", "100 CAD Covered CA Phase 3",
				null, "Incident","Tejaswini Alamuri", "S123788");
		td.addTaskDetails("INC0000004446101", "AD CDA ECONSULT", "110 CAD - Pre-Project Activities - 2015 MAS",
				null, "Incident","Tejaswini Alamuri", "S123788");
		
		MSMActivityLogDAO dao = new MSMActivityLogDAO();
		dao.addMSMActivity("CRQ0000003351016", "S123788", "January", 6, "Testing", "S123788");
		dao.addMSMActivity("CRQ0000004445817", "S123788", "January", 50, "Testing", "S123788");
		dao.addMSMActivity("CRQ0000004445823", "S123788", "January", 90, "Testing", "S123788");
		dao.addMSMActivity("CRQ0000004446101", "S123788", "January", 25, "Testing", "S123788");
		
		dao.addMSMActivity("INC0000003351016", "S123788", "January", 1, "Testing", "S123788");
		dao.addMSMActivity("INC0000004445817", "S123788", "January", 3, "Testing", "S123788");
		dao.addMSMActivity("INC0000004445823", "S123788", "January", 5, "Testing", "S123788");
		dao.addMSMActivity("INC0000004446101", "S123788", "January", 25, "Testing", "S123788");
		
		dao.addMSMActivity("TAS0000003351016", "S123788", "January", 1, "Testing", "S123788");
		dao.addMSMActivity("TAS0000004445817", "S123788", "January", 10, "Testing", "S123788");
		dao.addMSMActivity("TAS0000004445823", "S123788", "January", 120, "Testing", "S123788");
		dao.addMSMActivity("TAS0000004446101", "S123788", "January", 8, "Testing", "S123788");
		
		dao.addMSMActivity("WO0000003351016", "S123788", "January", 10, "Testing", "S123788");
		dao.addMSMActivity("WO0000004445817", "S123788", "January", 20, "Testing", "S123788");
		dao.addMSMActivity("WO0000004445823", "S123788", "January", 15, "Testing", "S123788");
		dao.addMSMActivity("WO0000004446101", "S123788", "January", 6, "Testing", "S123788");
		
		//dao.updateMSMActivityLog(2, 125, "E", "S123788");
		ArrayList<MSMActivityLog> list = dao.getEffortForTasks("S123788", "January");
		System.out.println("List size :"+list.size());
		
		TeamDetailsDAO teamDao = new TeamDetailsDAO();
		teamDao.addTeamMember("S123788", "B123788");
		teamDao.addTeamMember("S123788", "C123788");
		teamDao.addTeamMember("S123788", "D123788");
		teamDao.addTeamMember("A123788", "E123788");
		teamDao.addTeamMember("A123788", "F123788");
	}

}
