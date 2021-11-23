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
public class VisualAutoCreateRefService {
	
	public static String delcmd="del /f temp.json";
	
	public ResponseEntity<ResponseDto> getcreateReference(VisualAutoApproveDto visualAutoApproveDto) {
		ResponseDto response = new ResponseDto();
		if(visualAutoApproveDto.getProjectName().isEmpty() || visualAutoApproveDto.getEnvUrl().isEmpty() || visualAutoApproveDto.getCommand().isEmpty()) {
			
			String message = "Enter valid ";
			if(visualAutoApproveDto.getProjectName().isEmpty())
				message = message+ "Project Name";
			if(visualAutoApproveDto.getEnvUrl().isEmpty())
				message = message+ " " + "URL";
			if(visualAutoApproveDto.getCommand().isEmpty())
				message = message+" " +  "Command";
			response.setMessage( message);
			return ResponseEntity.ok().body(response);
		}
		final String projectFolderPath= "F:\\Flexib_Product\\Digital_Automation\\VisualAutomation\\"+visualAutoApproveDto.getProjectName();
		
		File dir=new File(projectFolderPath);
		if(!dir.exists()){
			response.setMessage("Folder is not available with given project name");
			return ResponseEntity.ok().body(response);
		}
		
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", "/c", "cd \"F:\\Flexib_Product\\Digital_Automation\\VisualAutomation\\"+visualAutoApproveDto.getProjectName()+"\" && copy backstop.json temp.json "
				+ " && jq -r \".scenarios[0].url |= \"\\\""
				+ visualAutoApproveDto.getEnvUrl() 
				+ "\\\"\"\" temp.json > backstop.json && "
				+ visualAutoApproveDto.getCommand()+"&&"+delcmd);
	
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
			if(line.contains("Error")) {
				response.setMessage("Invalid command :: "+visualAutoApproveDto.getCommand());
				return ResponseEntity.ok().body(response); 
			}
		}
		//System.out.println(sbuilder);
		if(visualAutoApproveDto.getCommand().toLowerCase().contains("reference")) {
			response.setMessage("project reference created successfully");
			return ResponseEntity.ok().body(response);			
		}
		
		response.setMessage("project executed successfully");
		return ResponseEntity.ok().body(response);
	}
}
