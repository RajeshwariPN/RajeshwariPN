package com.infotech.flexibautomation.dto;

import org.springframework.lang.NonNull;

public class CheckoutGithubAccessTokenDTO {
	
	@NonNull
	private String repositoryName;
	@NonNull
	private String cloneDirectoryPath;
	@NonNull
	private String repositoryUrl;
	@NonNull
	private String accessToken;
	
	public CheckoutGithubAccessTokenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckoutGithubAccessTokenDTO(String repositoryName, String cloneDirectoryPath, String repositoryUrl,
			String accessToken) {
		super();
		this.repositoryName = repositoryName;
		this.cloneDirectoryPath = cloneDirectoryPath;
		this.repositoryUrl = repositoryUrl;
		this.accessToken = accessToken;
	}

	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public String getCloneDirectoryPath() {
		return cloneDirectoryPath;
	}

	public void setCloneDirectoryPath(String cloneDirectoryPath) {
		this.cloneDirectoryPath = cloneDirectoryPath;
	}
	public String getRepositoryUrl() {
		return repositoryUrl;
	}
	public void setRepositoryUrl(String repositoryUrl) {
		this.repositoryUrl = repositoryUrl;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	

}
