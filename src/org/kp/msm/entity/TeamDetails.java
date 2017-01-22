package org.kp.msm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TEAM_DETAILS")
public class TeamDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LEAD_ID")
	private String leadId;
	
	@Column(name = "MEMBER_ID")
	private String memberId;
	
	@Column(name = "ENTRY_ID")
	private String entryId;
	
	@Column(name = "ENTRY_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryTs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public Date getEntryTs() {
		return entryTs;
	}

	public void setEntryTs(Date entryTs) {
		this.entryTs = entryTs;
	}

}
