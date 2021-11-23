package com.infotech.flexibautomation.dto;

public class SecurityDto {
	
	private String projectPath;
	private String accessKey;
	private String command;
	private String ProjectName;
	private String projectKey;
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public SecurityDto(String projectPath, String accessKey, String command, String projectName, String projectKey) {
		super();
		this.projectPath = projectPath;
		this.accessKey = accessKey;
		this.command = command;
		ProjectName = projectName;
		this.projectKey = projectKey;
	}
	public SecurityDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "SecurityDto [projectPath=" + projectPath + ", accessKey=" + accessKey + ", command=" + command
				+ ", ProjectName=" + ProjectName + ", projectKey=" + projectKey + "]";
	}
	
	
}
