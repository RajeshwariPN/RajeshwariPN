package com.infotech.flexibautomation.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.infotech.flexibautomation.dto.ResponseDto;
import com.infotech.flexibautomation.dto.VisualAutoApproveDto;

@Service
public class VisualAutoApproveDeclineService {

	public ResponseEntity<ResponseDto> getcreateApprove(VisualAutoApproveDto criteria) {
		
		criteria.setProjectName(criteria.getProjectName());
		criteria.setCommand(criteria.getCommand());
		
		 ResponseDto response = new ResponseDto();
		
		 if(criteria.projectName.isEmpty() ||  criteria.command.isEmpty()) {
			
			String message = "Enter valid ";
			if(criteria.projectName.isEmpty())
				message = message+ "Project Name";
			if(criteria.command.isEmpty())
				message = message+" " +  "Command";
			response.setMessage( message);
			return ResponseEntity.ok().body(response);
		}
		 
		final String ProjectFolderPath= "F:\\Flexib_Product\\Digital_Automation\\VisualAutomation";
		
		File dir=new File(ProjectFolderPath);
		if(!dir.exists()){
			response.setMessage("Folder is not available with given project name");
			return ResponseEntity.ok().body(response);
		}
		
		ProcessBuilder builder = new ProcessBuilder
		("cmd.exe", "/c", "cd \"F:\\Flexib_Product\\Digital_Automation\\VisualAutomation\\"+criteria.getProjectName()+ "\" &&"+ criteria.getCommand());
		builder.redirectErrorStream(true);
		Process p = null;
		
		try {
			p = builder.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sbuilder=new StringBuilder();
		
		while (true) {
		try {
			line = r.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if (line == null)
			break;
		if(line.contains("Error")) {
			response.setMessage("Invalid command :: "+criteria.getCommand());
			return ResponseEntity.ok().body(response); 
		}
	}
	//System.out.println(sbuilder);
	if(criteria.getCommand().toLowerCase().contains("approve")) {
		response.setMessage("project Approved successfully");
		return ResponseEntity.ok().body(response);			
	}
	
	response.setMessage("project  Declined successfully");
	return ResponseEntity.ok().body(response);
}
	
}







