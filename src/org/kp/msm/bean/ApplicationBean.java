package org.kp.msm.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ApplicationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appName;
	private String description;
	private String taskId;
	private String catNumber;

	public String getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(String catNumber) {
		this.catNumber = catNumber;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	

}
