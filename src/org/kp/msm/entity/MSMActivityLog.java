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
@Table(name="MSM_ACTIVITY_LOG")
public class MSMActivityLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long Id;
	
	@Column(name = "TASK_ID")
	private String TaskId;
	
	@Column(name = "USER_ID")
	private String UserId;
	
	@Column(name = "MONTH")
	private String Month;
	
	@Column(name = "HOURS")
	private int Hours;
	
	@Column(name = "DETAILED_DESC")
	private String DetailedDesc;
	
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
	
	@Column(name ="UPDT_FLAG")
	private String UpdateFlag;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTaskId() {
		return TaskId;
	}

	public void setTaskId(String taskId) {
		TaskId = taskId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public int getHours() {
		return Hours;
	}

	public void setHours(int hours) {
		Hours = hours;
	}

	public String getDetailedDesc() {
		return DetailedDesc;
	}

	public void setDetailedDesc(String detailedDesc) {
		DetailedDesc = detailedDesc;
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

	public String getUpdateFlag() {
		return UpdateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		UpdateFlag = updateFlag;
	}

}
