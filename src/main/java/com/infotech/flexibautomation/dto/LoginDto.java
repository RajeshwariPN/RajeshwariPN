package com.infotech.flexibautomation.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {
	
    private @NotBlank String userName;
    private @NotBlank String password;
    private @NotBlank String projectName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LoginDto(@NotBlank String userName, @NotBlank String password, @NotBlank String projectName) {
		super();
		this.userName = userName;
		this.password = password;
		this.projectName = projectName;
	}
	public LoginDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + ", projectName=" + projectName + "]";
	}
    
	

}
