package com.infotech.flexibautomation.dto;

import javax.validation.constraints.NotEmpty;


public class ReportFind {
	
	@NotEmpty()
	private String projectPath;
	@NotEmpty()
	private String reportname;
	@NotEmpty()
	private String reposubpath;

	
	
	public ReportFind() {
		super();
	}

	public ReportFind(String projectPath, String reportname) {
		super();
		this.projectPath = projectPath;
		this.reportname = reportname;
		this.reposubpath=reposubpath;
	}

	public String getprojectPath() {
		return projectPath;
	}

	public void setprojectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getreportname() {
		return reportname;
	}

	public void setreportname(String reportname) {
		this.reportname = reportname;
	}
	public String getreposubpath() {
		return reposubpath;
	}

	public void setreposubpath(String reposubpath) {
		this.reposubpath = reposubpath;
	}


	}
