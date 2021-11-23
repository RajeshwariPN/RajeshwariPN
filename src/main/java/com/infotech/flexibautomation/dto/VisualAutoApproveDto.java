package com.infotech.flexibautomation.dto;

public class VisualAutoApproveDto {
	
	public String projectName;
	public String command;
	public String envUrl;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getEnvUrl() {
		return envUrl;
	}
	public void setEnvUrl(String envUrl) {
		this.envUrl = envUrl;
	}
	public VisualAutoApproveDto() {
		super();
		
	}
	@Override
	public String toString() {
		return "VisualAutoApproveDto [projectName=" + projectName + ", command=" + command + ", envUrl=" + envUrl + "]";
	}
	public VisualAutoApproveDto(String projectName, String command, String envUrl) {
		super();
		this.projectName = projectName;
		this.command = command;
		this.envUrl = envUrl;
	}
}
