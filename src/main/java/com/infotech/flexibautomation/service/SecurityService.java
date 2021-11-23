package com.infotech.flexibautomation.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.infotech.flexibautomation.dto.ResponseDto;
import com.infotech.flexibautomation.dto.SecurityDto;

@Service
public class SecurityService {

	
	public ResponseEntity<ResponseDto> getsecurityService(SecurityDto securityDto) throws IOException {
		
		ResponseDto response = new ResponseDto();
		if(securityDto.getProjectPath().isEmpty() || securityDto.getAccessKey().isEmpty() || securityDto.getCommand().isEmpty()) {
			
		String message = "Enter valid ";
		if(securityDto.getProjectPath().isEmpty())
			message = message+ "Project Path";
		
		if(securityDto.getAccessKey().isEmpty())
			message = message+ " " + "AccessKey";
		if(securityDto.getCommand().isEmpty())
			message = message+ " " +  "Command";
		response.setMessage( message);
		
		return ResponseEntity.ok().body(response);
	}
		
		
		String projectPath  = securityDto.getProjectPath();
		String projectBaseDir = projectPath.replace("\\", "/");
		//System.out.println("Project pathe is  "+projectPath);
		//System.out.println("Project base path is "+projectBaseDir);
		/*ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", projectPath.substring(0, 2) + " && cd  "
				//projectPath + "&& type nul  > hello.txt");
				+ projectPath + "&& copy D:\\shoppincartcoderepo-main\\shoppincartcoderepo-main\\Shoppingcart\\Shoppingcart\\sonar-project-properties.properties D:\\securityAPI\\Shoppingcart "
				+ securityDto.getCommand() + "-Dsonar.login=" + securityDto.getAccessKey() + "-Dsonar.projectName=" +securityDto.getProjectName()
				+ "-Dsonar.projectKey=" +securityDto.getProjectKey()+ "-Dsonar.projectBaseDir=" + projectBaseDir);*/
		
	ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", projectPath.substring(0, 2) + " && cd  " + 
				//projectPath + "&& type nul  > hello.txt");
				projectPath + "&& copy F:\\SecutituSonarAPI\\PropertiesFile F:\\SecutituSonarAPI\\Shoppingcart "
						+ "&& sonar-scanner -Dsonar.login=" + securityDto.getAccessKey() + "  -Dsonar.projectName=" +securityDto.getProjectName()
								+ " -Dsonar.projectKey=" +securityDto.getProjectKey()+ " -Dsonar.projectBaseDir=" + projectBaseDir);
		

	
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
			if(line.contains("Error")) {
				response.setMessage("Invalid command :: "+securityDto.getCommand());
				return ResponseEntity.ok().body(response); 
			}
		}
		//System.out.println(sbuilder);
		if(securityDto.getCommand().toLowerCase().contains("sonar-scanner")) {
			response.setMessage("code executed successfully.please check the report for issues");
			return ResponseEntity.ok().body(response);			
		}
		
		//response.setMessage("code executed successfully.please check the report for issues");
		return ResponseEntity.ok().body(response);
	}
}