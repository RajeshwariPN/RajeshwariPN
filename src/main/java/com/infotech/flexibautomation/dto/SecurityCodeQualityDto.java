package com.infotech.flexibautomation.dto;

//import javax.validation.constraints.NotNull;

public class SecurityCodeQualityDto {
	
	//@NotNull
	private String projectName;
	
	//@NotNull
	private String projectPath;
	
	//@NotNull
	private String ReportPath;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getReportPath() {
		return ReportPath;
	}
	public void setReportPath(String reportPath) {
		ReportPath = reportPath;
	}
	public SecurityCodeQualityDto(String projectName, String projectPath, String reportPath) {
		super();
		this.projectName = projectName;
		this.projectPath = projectPath;
		ReportPath = reportPath;
	}
	public SecurityCodeQualityDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "SecurityCodeQualityDto [projectName=" + projectName + ", projectPath=" + projectPath + ", ReportPath="
				+ ReportPath + "]";
	}
	

}
