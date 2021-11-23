package com.infotech.flexibautomation.dto;

public class EmployeeDetailsDto {
	
	private String employer;
	private String emplyersPhone;
	private String employmentStatus;
	private String howOftenAreYouPaid;
	private String lastPaidDate;
	private String NextPayDate;
	private Integer lastTakeHomePayChequeAmount;
	private Integer takeHomeForTheMonthOfMay;
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getEmplyersPhone() {
		return emplyersPhone;
	}
	public void setEmplyersPhone(String emplyersPhone) {
		this.emplyersPhone = emplyersPhone;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getHowOftenAreYouPaid() {
		return howOftenAreYouPaid;
	}
	public void setHowOftenAreYouPaid(String howOftenAreYouPaid) {
		this.howOftenAreYouPaid = howOftenAreYouPaid;
	}
	public String getLastPaidDate() {
		return lastPaidDate;
	}
	public void setLastPaidDate(String lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}
	public String getNextPayDate() {
		return NextPayDate;
	}
	public void setNextPayDate(String nextPayDate) {
		NextPayDate = nextPayDate;
	}
	public Integer getLastTakeHomePayChequeAmount() {
		return lastTakeHomePayChequeAmount;
	}
	public void setLastTakeHomePayChequeAmount(Integer lastTakeHomePayChequeAmount) {
		this.lastTakeHomePayChequeAmount = lastTakeHomePayChequeAmount;
	}
	public Integer getTakeHomeForTheMonthOfMay() {
		return takeHomeForTheMonthOfMay;
	}
	public void setTakeHomeForTheMonthOfMay(Integer takeHomeForTheMonthOfMay) {
		this.takeHomeForTheMonthOfMay = takeHomeForTheMonthOfMay;
	}
	public EmployeeDetailsDto(String employer, String emplyersPhone, String employmentStatus, String howOftenAreYouPaid,
			String lastPaidDate, String nextPayDate, Integer lastTakeHomePayChequeAmount,
			Integer takeHomeForTheMonthOfMay) {
		super();
		this.employer = employer;
		this.emplyersPhone = emplyersPhone;
		this.employmentStatus = employmentStatus;
		this.howOftenAreYouPaid = howOftenAreYouPaid;
		this.lastPaidDate = lastPaidDate;
		NextPayDate = nextPayDate;
		this.lastTakeHomePayChequeAmount = lastTakeHomePayChequeAmount;
		this.takeHomeForTheMonthOfMay = takeHomeForTheMonthOfMay;
	}
	public EmployeeDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDetailsDto [employer=" + employer + ", emplyersPhone=" + emplyersPhone + ", employmentStatus="
				+ employmentStatus + ", howOftenAreYouPaid=" + howOftenAreYouPaid + ", lastPaidDate=" + lastPaidDate
				+ ", NextPayDate=" + NextPayDate + ", lastTakeHomePayChequeAmount=" + lastTakeHomePayChequeAmount
				+ ", takeHomeForTheMonthOfMay=" + takeHomeForTheMonthOfMay + "]";
	}
	
	
	
	

}
