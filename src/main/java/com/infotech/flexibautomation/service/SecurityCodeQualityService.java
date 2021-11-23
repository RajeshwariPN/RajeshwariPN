package com.infotech.flexibautomation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infotech.flexibautomation.dto.ResponseDto;
import com.infotech.flexibautomation.dto.SecurityCodeQualityDto;

@Service
public class SecurityCodeQualityService {

	public ResponseEntity<ResponseDto> getcodeQuality(SecurityCodeQualityDto securityCodeQualityDto) {
		
		ResponseDto response = new ResponseDto();
		if(securityCodeQualityDto.getProjectName().isEmpty() || securityCodeQualityDto.getProjectPath().isEmpty() || securityCodeQualityDto.getReportPath().isEmpty()) {
			
		String message = "Enter valid ";
		if(securityCodeQualityDto.getProjectName().isEmpty())
			message = message+ "Project Name";
		if(securityCodeQualityDto.getProjectPath().isEmpty())
			message = message+ " " + "Project Path";
		if(securityCodeQualityDto.getReportPath().isEmpty())
			message = message+ " " +  "Report Path";
		response.setMessage( message);
		
		return ResponseEntity.ok().body(response);
	}
		
	String projectName = securityCodeQualityDto.getProjectName();
	String projectPath = securityCodeQualityDto.getProjectPath();
	String reportPath = securityCodeQualityDto.getReportPath();
	String path="F:\\";
	
	
	ProcessBuilder builder = new ProcessBuilder(
			"cmd.exe", "/c", "cd " +path+ " && "+"dependency-check --noupdate --project\s" +projectName+ " --scan\s"+ projectPath+ " --format HTML --out \s" +reportPath);

	builder.redirectErrorStream(true);
	Process p;
	try {
		p = builder.start();
	} catch (IOException e) {
		e.printStackTrace();
		
		response.setMessage(""+e);
		return ResponseEntity.ok().body(response);
	}
	
	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String line = null;
	StringBuilder sbuilder=new StringBuilder();
	
	while (true) {
		try {
			line = r.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			
			response.setMessage(""+e);
			return ResponseEntity.ok().body(response);
		}
		if (line == null)
			break;
		sbuilder=sbuilder.append(line);
		sbuilder.append(System.lineSeparator());
	}
	System.out.println(sbuilder);

	response.setMessage("vulnerable libraries scanned successfrully with the selected code base.");
	return ResponseEntity.ok().body(response);
}

}
