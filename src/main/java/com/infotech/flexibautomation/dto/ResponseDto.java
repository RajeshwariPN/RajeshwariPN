package com.infotech.flexibautomation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
	
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDto(String message) {
		super();
		this.message = message;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResponseDto [message=" + message + "]";
	}
	
}
