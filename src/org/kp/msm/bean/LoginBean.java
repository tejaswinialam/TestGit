package org.kp.msm.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class LoginBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String isAdmin;
	private boolean auth;
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBean()
	{
		
	}
	
	public LoginBean(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

}
