package com.infotech.flexibautomation.dto;

public class ReportResponseDto {
	
	private Integer status;
	private String message;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ReportResponseDto(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ReportResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReportResponseDto [status=" + status + ", message=" + message + "]";
	}
	
}
