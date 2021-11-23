package com.infotech.flexibautomation.dto;
import javax.validation.constraints.NotEmpty;

public class MobileAutomation {
	@NotEmpty()
	private String projectPath;
	@NotEmpty()
	private String deviceName;
	@NotEmpty()
	private String osversion;
	@NotEmpty()
	private String platformName;
	@NotEmpty()
	private String browserName;
	@NotEmpty()
	private String userName;
	@NotEmpty()
	private String accesskey;
	@NotEmpty()
	private String testName;
	@NotEmpty()
	private String buildName;
	
	public MobileAutomation() {
		super();
	}

	public MobileAutomation(String projectPath, String repoURL, String accessToken) {
		super();
		this.projectPath = projectPath;
		this.deviceName = deviceName;
		this.osversion = osversion;
		this.platformName = platformName;
		this.browserName = browserName;
		this.userName = userName;
		this.accesskey = accesskey;
		this.testName = testName;
		this.buildName = buildName;
	}

	public String getprojectPath() {
		return projectPath;
	}

	public void setprojectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getdeviceName() {
		return deviceName;
	}

	public void setdeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getosversion() {
		return osversion;
	}

	public void setosversion(String osversion) {
		this.osversion = osversion;
	}
	public String getplatformName() {
		return platformName;
	}

	public void setplatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getbrowserName() {
		return browserName;
	}

	public void setbrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getaccesskey() {
		return accesskey;
	}

	public void setaccesskey(String accesskey) {
		this.accesskey = accesskey;
	}
	public String gettestName() {
		return testName;
	}

	public void settestName(String testName) {
		this.testName = testName;
	}
	public String getbuildName() {
		return buildName;
	}

	public void setbuildName(String buildName) {
		this.buildName = buildName;
	}

}
