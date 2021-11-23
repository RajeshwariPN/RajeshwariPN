package com.infotech.flexibautomation.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;


@Entity
@Table(name = "avoka_results")
public class AvokaResults {
		
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Testcase_Id")
	private String testCaseId;
	
	@Column(name = "Test_case_name")
	private String testCaseName;
	
	@Column(name = "Test_Desc")
	private String testDescription;
	
	@Column(name = "Test_Script_Name")
	private String testScriptName;
	
	@Column(name = "Environment")
	private String environment;
	
	@Column(name = "Device")
	private String device;
	
	@Column(name = "OS")
	private String operatingSystem;
	
	@Column(name = "Version")
	private String version;
	
	@Column(name = "Browser")
	private String browser;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Testcaseremarks")
	private String testCaseRemarks;
	
	@Column(name = "Executedat")
	private String executedAt;
	
	@Column(name = "date_excuted")
	private Date dateExecuted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getTestScriptName() {
		return testScriptName;
	}

	public void setTestScriptName(String testScriptName) {
		this.testScriptName = testScriptName;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestCaseRemarks() {
		return testCaseRemarks;
	}

	public void setTestCaseRemarks(String testCaseRemarks) {
		this.testCaseRemarks = testCaseRemarks;
	}

	public String getExecutedAt() {
		return executedAt;
	}

	public void setExecutedAt(String executedAt) {
		this.executedAt = executedAt;
	}

	public String getDateExecuted() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		String strDate = sdf.format(dateExecuted);
		return strDate;
		
	}

	public void setDateExecuted(Date dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public AvokaResults(Integer id, String testCaseId, String testCaseName, String testDescription,
			String testScriptName, String environment, String device, String operatingSystem, String version,
			String browser, String status, String testCaseRemarks, String executedAt, Date dateExecuted) {
		super();
		this.id = id;
		this.testCaseId = testCaseId;
		this.testCaseName = testCaseName;
		this.testDescription = testDescription;
		this.testScriptName = testScriptName;
		this.environment = environment;
		this.device = device;
		this.operatingSystem = operatingSystem;
		this.version = version;
		this.browser = browser;
		this.status = status;
		this.testCaseRemarks = testCaseRemarks;
		this.executedAt = executedAt;
		this.dateExecuted = dateExecuted;
	}

	public AvokaResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AvokaResults [id=" + id + ", testCaseId=" + testCaseId + ", testCaseName=" + testCaseName
				+ ", testDescription=" + testDescription + ", testScriptName=" + testScriptName + ", environment="
				+ environment + ", device=" + device + ", operatingSystem=" + operatingSystem + ", version=" + version
				+ ", browser=" + browser + ", status=" + status + ", testCaseRemarks=" + testCaseRemarks
				+ ", executedAt=" + executedAt + ", dateExecuted=" + dateExecuted + "]";
	}

	
	
	
	
}
