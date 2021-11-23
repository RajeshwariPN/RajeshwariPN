package com.infotech.flexibautomation.dto;

public class UsersDto {
	
	private Integer id;
	private String userName;
	private String emailId;
	private String firstName;
	private String lastName;
	private String contactNum;
	private String Password;
	private String confirmPassword;
	private String projectName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public UsersDto(Integer id, String userName, String emailId, String firstName, String lastName, String contactNum,
			String password, String confirmPassword, String projectName) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNum = contactNum;
		Password = password;
		this.confirmPassword = confirmPassword;
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNum=" + contactNum + ", Password=" + Password
				+ ", confirmPassword=" + confirmPassword + ", projectName=" + projectName + "]";
	}
	public UsersDto() {
		super();
	}
	
	
}
