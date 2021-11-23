package com.infotech.flexibautomation.dto;

public class SearchCriteriaDTO {
	
	private Integer pageNo = 0;
	private Integer pageSize = 5;
	private String status;
	private String fromDate;
	private String toDate;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public SearchCriteriaDTO(Integer pageNo, Integer pageSize, String status, String fromDate, String toDate) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.status = status;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public SearchCriteriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SearchCriteriaDTO [pageNo=" + pageNo + ", pageSize=" + pageSize + ", status=" + status + ", fromDate="
				+ fromDate + ", toDate=" + toDate + "]";
	}
	
	
 
}
