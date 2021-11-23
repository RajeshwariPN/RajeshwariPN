package com.infotech.flexibautomation.dto;


public class ExcelHeaders {
	
	private String testCase_Id;
	private String testCaseName;
	private String testDesc;
	private String testScriptName;
	private String runMode;
	
	public ExcelHeaders() {
		super();
	}

	public ExcelHeaders(String testCase_Id, String testCaseName, String testDesc, String testScriptName,
			String runMode) {
		super();
		this.testCase_Id = testCase_Id;
		this.testCaseName = testCaseName;
		this.testDesc = testDesc;
		this.testScriptName = testScriptName;
		this.runMode = runMode;
	}

	public String getTestCase_Id() {
		return testCase_Id;
	}

	public void setTestCase_Id(String testCase_Id) {
		this.testCase_Id = testCase_Id;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getTestScriptName() {
		return testScriptName;
	}

	public void setTestScriptName(String testScriptName) {
		this.testScriptName = testScriptName;
	}

	public String getRunMode() {
		return runMode;
	}

	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}
	
	
	

}
