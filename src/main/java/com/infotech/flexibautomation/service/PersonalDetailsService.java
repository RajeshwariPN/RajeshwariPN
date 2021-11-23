package com.infotech.flexibautomation.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.infotech.flexibautomation.dto.PersonalDetailsDto;
import com.infotech.flexibautomation.dto.ReportResponseDto;

@Service
public class PersonalDetailsService {

	public ResponseEntity<ReportResponseDto> getPersonalDetails(PersonalDetailsDto personalDetailsDto) {
		
		ReportResponseDto response = new ReportResponseDto();
		
		System.out.println("$$ "+ isValidMobileNo(personalDetailsDto.getMobNum()));
		
		if(!isValidMobileNo(personalDetailsDto.getMobNum())){
			System.out.println("$$2");
			response.setStatus(500);
			response.setMessage("Enter valid mobile number");
			return ResponseEntity.ok().body(response);
		}
	
		else {
			response.setStatus(200);
			response.setMessage("success");
			return ResponseEntity.ok().body(response);
			}
		
	}
	
	public static boolean isValidMobileNo(String str)  
	{  
	//[1-9]: starting of the number may contain a digit between 1 to 9  
	//[0-9]: then contains digits 0 to 9  
	Pattern ptrn = Pattern.compile("[1-9][0-9]{9}");  
	//the matcher() method creates a matcher that will match the given input against this pattern  
	Matcher match = ptrn.matcher(str);  
	//returns a boolean value  
	return (match.find() && match.group().equals(str));  
	}  

}
