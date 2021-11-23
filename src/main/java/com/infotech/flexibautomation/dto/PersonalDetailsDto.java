package com.infotech.flexibautomation.dto;

public class PersonalDetailsDto {
	
	private String firstName;
	private String lastName;
	private String gender;
	private String datefBirth;
	private String panNum;
	private String mobNum;
	private String email;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDatefBirth() {
		return datefBirth;
	}
	public void setDatefBirth(String datefBirth) {
		this.datefBirth = datefBirth;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PersonalDetailsDto(String firstName, String lastName, String gender, String datefBirth, String panNum,
			String mobNum, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.datefBirth = datefBirth;
		this.panNum = panNum;
		this.mobNum = mobNum;
		this.email = email;
	}
	public PersonalDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PersonalDetailsDto [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", datefBirth=" + datefBirth + ", panNum=" + panNum + ", mobNum=" + mobNum + ", email=" + email + "]";
	}
	

}
