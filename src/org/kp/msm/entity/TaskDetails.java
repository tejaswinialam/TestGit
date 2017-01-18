package org.kp.msm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TASK_DETAILS")
public class TaskDetails {

	@Id
	@Column(name = "TASK_ID")
	private String TaskId;
	
	@Column(name ="APP_NAME")
	private String ApplicationName;
	
	@Column(name = "DESCRIPTION")
	private String Description;
	
	@Column(name = "TYPE")
	private String Type;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "ENTRY_ID")
	private String EntryId;
	
	@Column(name = "ENTRY_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date EntryTimeStamp;

	public String getTaskId() {
		return TaskId;
	}

	public void setTaskId(String taskId) {
		TaskId = taskId;
	}

	public String getApplicationName() {
		return ApplicationName;
	}

	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
}
