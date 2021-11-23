package com.infotech.flexibautomation.dto;

public class PerformanceDashboardErrorCountDTO {

	private Integer totalCount;
	private Integer passCount;
	private Integer failedCount;
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPassCount() {
		return passCount;
	}
	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}
	public Integer getFailedCount() {
		return failedCount;
	}
	public void setFailedCount(Integer failedCount) {
		this.failedCount = failedCount;
	}
	public PerformanceDashboardErrorCountDTO(Integer totalCount, Integer passCount, Integer failedCount) {
		super();
		this.totalCount = totalCount;
		this.passCount = passCount;
		this.failedCount = failedCount;
	}
	public PerformanceDashboardErrorCountDTO() {
		super();
		
	}
}
