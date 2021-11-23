package com.infotech.flexibautomation.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.infotech.flexibautomation.dto.ResponseDto;
import com.infotech.flexibautomation.dto.VisualAutoInitDto;



@Service
public class VisualAutoInitService {

	
	public ResponseEntity<ResponseDto> getcreateInit(VisualAutoInitDto visualAutoInitDto) {
		
		ResponseDto response = new ResponseDto();
		
		if(visualAutoInitDto.getProjectName().isEmpty()) {
			String message = "Enter valid Project Name";
			response.setMessage( message);
			return ResponseEntity.ok().body(response);
			//return null;
		
	}
		
		final String ProjectFolderPath= "F:\\Flexib_Product\\Digital_Automation\\VisualAutomation";
		File dir1=new File(ProjectFolderPath +"/" + visualAutoInitDto.getProjectName());
		if(dir1.exists()){
		System.out.println("A project name " + visualAutoInitDto.getProjectName()+ " is already exist in the path "+ProjectFolderPath );
		}
		else{
		       dir1.mkdir();
		     }
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"F:\\Flexib_Product\\Digital_Automation\\VisualAutomation\\"+visualAutoInitDto.getProjectName()+"\" && backstop init");
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
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	System.out.println(p.info());
		
		while (true) {
		try {
			line = r.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if (line == null)
		{
		break;
		}
		sbuilder=sbuilder.append(line);
		sbuilder.append(System.lineSeparator());
		}
		
		System.out.println(sbuilder);
		response.setMessage("Project crated successfully");
		return ResponseEntity.ok().body(response);
		
	}
}
