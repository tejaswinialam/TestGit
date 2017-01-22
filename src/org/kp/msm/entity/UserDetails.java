package org.kp.msm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@Column(name ="USER_ID")
	private String UserId;
	
	@Column(name ="PASSWORD")
	private String Password;
	
	@Column(name="FIRST_NAME")
	private String FirstName;
	
	@Column(name = "LAST_NAME")
	private String LastName;
	
	@Column(name ="EMAIL")
	private String Email;
	
	@Column(name = "ADMIN")
	private boolean Admin;
	
	@Column(name = "ENTRY_ID")
	private String EntryId;
	
	@Column(name = "ENTRY_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date EntryTimeStamp;
	
	@Column(name = "UPDT_ID")
	private String UpdateId;
	
	@Column(name = "UPDT_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdateTimeStamp;
	
	@Column(name = "ACTIVE_IND")
	private String activeIndicator;
	

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean getAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public String getEntryId() {
		return EntryId;
	}

	public void setEntryId(String entryId) {
		EntryId = entryId;
	}

	public Date getEntryTimeStamp() {
		return EntryTimeStamp;
	}

	public void setEntryTimeStamp(Date entryTimeStamp) {
		EntryTimeStamp = entryTimeStamp;
	}

	public String getUpdateId() {
		return UpdateId;
	}

	public void setUpdateId(String updateId) {
		UpdateId = updateId;
	}

	public Date getUpdateTimeStamp() {
		return UpdateTimeStamp;
	}

	public void setUpdateTimeStamp(Date updateTimeStamp) {
		UpdateTimeStamp = updateTimeStamp;
	}

	public String getActiveIndicator() {
		return activeIndicator;
	}

	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	
	
	


}
