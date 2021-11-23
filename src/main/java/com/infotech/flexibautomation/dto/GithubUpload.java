package com.infotech.flexibautomation.dto;

import javax.validation.constraints.NotEmpty;


public class GithubUpload {
	
	@NotEmpty()
	private String projectPath;
	@NotEmpty()
	private String repoURL;
	@NotEmpty()
	private String accessToken;
	
	
	public GithubUpload() {
		super();
	}

	public GithubUpload(String projectPath, String repoURL, String accessToken) {
		super();
		this.projectPath = projectPath;
		this.repoURL = repoURL;
		this.accessToken = accessToken;
	}

	public String getprojectPath() {
		return projectPath;
	}

	public void setprojectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getrepoURL() {
		return repoURL;
	}

	public void setrepoURL(String repoURL) {
		this.repoURL = repoURL;
	}

	public String getaccessToken() {
		return accessToken;
	}

	public void setaccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	}
