package com.infotech.flexibautomation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infotech.flexibautomation.dto.EmployeeDetailsDto;
import com.infotech.flexibautomation.dto.ReportResponseDto;

@Service
public class EmployeeDetailsService {

	public ResponseEntity<ReportResponseDto> getEmployeeDetails(EmployeeDetailsDto employeeDetailsDto) {
		
		ReportResponseDto response = new ReportResponseDto();
		
		System.out.println("$$$1 " + (employeeDetailsDto.getLastTakeHomePayChequeAmount() <= 2000));
		
		if(employeeDetailsDto.getLastTakeHomePayChequeAmount() <= 2000) {
			System.out.println("$$$2");
			response.setStatus(500);
			response.setMessage("decline");
			return ResponseEntity.ok().body(response);
		}
		else {
			response.setStatus(200);
			response.setMessage("success");
			return ResponseEntity.ok().body(response);
		}
	}
	
}

