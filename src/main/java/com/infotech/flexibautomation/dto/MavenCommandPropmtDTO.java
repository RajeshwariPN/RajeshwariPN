package com.infotech.flexibautomation.dto;

public class MavenCommandPropmtDTO {
	
	private String projectPath;
	private String mavenCommand;
	
	public MavenCommandPropmtDTO() {
		super();
	}

	public MavenCommandPropmtDTO(String projectPath, String mavenCommand) {
		super();
		this.projectPath = projectPath;
		this.mavenCommand = mavenCommand;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getMavenCommand() {
		return mavenCommand;
	}

	public void setMavenCommand(String mavenCommand) {
		this.mavenCommand = mavenCommand;
	}

}
