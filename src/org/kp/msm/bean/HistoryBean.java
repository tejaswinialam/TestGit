package org.kp.msm.bean;

public class HistoryBean {

	private String categoryDescription;
	private String type;
	private String category;
	private String categoryNumber;
	private String effort;
	private String updateFlag;
	private String adhocComments;
	public String getAdhocComments() {
		return adhocComments;
	}
	public void setAdhocComments(String adhocComments) {
		this.adhocComments = adhocComments;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public String getDecription() {
		return categoryDescription;
	}
	public void setDecription(String decription) {
		this.categoryDescription = decription;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCatNumber() {
		return categoryNumber;
	}
	public void setCatNumber(String catNumber) {
		this.categoryNumber = catNumber;
	}
	public String getEffort() {
		return effort;
	}
	public void setEffort(String effort) {
		this.effort = effort;
	}
	
	
}
