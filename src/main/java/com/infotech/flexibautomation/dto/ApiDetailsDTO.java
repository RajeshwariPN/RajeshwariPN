package com.infotech.flexibautomation.dto;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

public class ApiDetailsDTO {
	
	@NotEmpty()
	private String protocol;
	@NotEmpty()
	private String serverName;
	@NotEmpty()
	private String subURL;
	@NotEmpty()
	private String portNumber;
	@NotEmpty()
	private String methodType;
	@NotEmpty()
	private String reqBody;
	@NotEmpty()
	private String contentEncoding;
	@NotEmpty()
	private String isAuthentication;

	private Map<String, String> authHeaders;

	
	public ApiDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiDetailsDTO(@NotEmpty String protocol, @NotEmpty String serverName, @NotEmpty String subURL,
			@NotEmpty String portNumber, @NotEmpty String methodType, @NotEmpty String reqBody,
			@NotEmpty String contentEncoding, @NotEmpty String isAuthentication,
			Map<String, String> authHeaders) {
		super();
		this.protocol = protocol;
		this.serverName = serverName;
		this.subURL = subURL;
		this.portNumber = portNumber;
		this.methodType = methodType;
		this.reqBody = reqBody;
		this.contentEncoding = contentEncoding;
		this.isAuthentication = isAuthentication;
		this.authHeaders = authHeaders;
	}
	
	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getSubURL() {
		return subURL;
	}

	public void setSubURL(String subURL) {
		this.subURL = subURL;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getReqBody() {
		return reqBody;
	}

	public void setReqBody(String reqBody) {
		this.reqBody = reqBody;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}

	public String getIsAuthentication() {
		return isAuthentication;
	}

	public void setIsAuthentication(String isAuthentication) {
		this.isAuthentication = isAuthentication;
	}

	public Map<String, String> getAuthHeaders() {
		return authHeaders;
	}

	public void setAuthHeaders(Map<String, String> authHeaders) {
		this.authHeaders = authHeaders;
	}
	
}
