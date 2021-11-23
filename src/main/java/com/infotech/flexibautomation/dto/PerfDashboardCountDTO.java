package com.infotech.flexibautomation.dto;

public class PerfDashboardCountDTO {
	
	private String fromDate;
	private String toDate;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public PerfDashboardCountDTO(String fromDate, String toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public PerfDashboardCountDTO() {
		super();
		
	}
	@Override
	public String toString() {
		return "PerfDashboardCountDTO [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	

}
