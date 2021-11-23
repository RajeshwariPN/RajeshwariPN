package com.infotech.flexibautomation.dto;

import javax.validation.constraints.NotEmpty;


public class JmeterCommandDTO {
	
	@NotEmpty()
	private String jServerUrl;
	@NotEmpty()
	private String jPorntNo;
	@NotEmpty()
	private String jUserCount;
	@NotEmpty()
	private String jDuration;
	@NotEmpty()
	private String jRampUp;
	@NotEmpty()
	private String jRampDown;
	
	
	public JmeterCommandDTO() {
		super();
	}

	public JmeterCommandDTO(String jServerUrl, String jPorntNo, String jUserCount, String jDuration, String jRampUp,
			String jRampDown) {
		super();
		this.jServerUrl = jServerUrl;
		this.jPorntNo = jPorntNo;
		this.jUserCount = jUserCount;
		this.jDuration = jDuration;
		this.jRampUp = jRampUp;
		this.jRampDown = jRampDown;
	}

	public String getjServerUrl() {
		return jServerUrl;
	}

	public void setjServerUrl(String jServerUrl) {
		this.jServerUrl = jServerUrl;
	}

	public String getjPorntNo() {
		return jPorntNo;
	}

	public void setjPorntNo(String jPorntNo) {
		this.jPorntNo = jPorntNo;
	}

	public String getjUserCount() {
		return jUserCount;
	}

	public void setjUserCount(String jUserCount) {
		this.jUserCount = jUserCount;
	}

	public String getjDuration() {
		return jDuration;
	}

	public void setjDuration(String jDuration) {
		this.jDuration = jDuration;
	}

	public String getjRampUp() {
		return jRampUp;
	}

	public void setjRampUp(String jRampUp) {
		this.jRampUp = jRampUp;
	}

	public String getjRampDown() {
		return jRampDown;
	}

	public void setjRampDown(String jRampDown) {
		this.jRampDown = jRampDown;
	}
}
