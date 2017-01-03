package org.kp.msm.bean;

import java.util.ArrayList;

public class ResponseBean {
	
	public ArrayList<ApplicationBean> getBeanList() {
		return beanList;
	}
	public void setBeanList(ArrayList<ApplicationBean> beanList) {
		this.beanList = beanList;
	}
	public ArrayList<HistoryBean> getHistoryBeanList() {
		return historyBeanList;
	}
	public void setHistoryBeanList(ArrayList<HistoryBean> historyBeanList) {
		this.historyBeanList = historyBeanList;
	}
	private ArrayList<ApplicationBean> beanList;
	private ArrayList<HistoryBean> historyBeanList;

}
