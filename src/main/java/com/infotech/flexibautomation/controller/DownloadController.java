package com.infotech.flexibautomation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.infotech.flexibautomation.service.FlexibService;

@Controller
public class DownloadController {
	@Autowired
	private  FlexibService flexSvc;
	
	@GetMapping("/auto")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "Automation";
	}

	
	@GetMapping("/perf")
	public String sayPerfFileDownload(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "Performance";
	}

	@PostMapping("/checkout")
	public String sayAutomation(Model theModel) {
		
		System.out.println("$$$$$$ The automation method is called");
		theModel.addAttribute("theGitStatus", flexSvc.createClone());
		
		
		return "Automation";
	}

	//file download for automation page
	
	@GetMapping("/autodownload")
	public ResponseEntity<Resource> sayAutoFileDownload() throws IOException {
		
		System.out.println("$$$$$$ The download method is called for automation page");
	
		return flexSvc.autodownload();
	}
	
	//file download for performance page
		
		@GetMapping("/perfdownload")
		public ResponseEntity<Resource> sayPerfFileDownload1() throws IOException {
			
			System.out.println("$$$$$$ The download method is called for performance page");
		
			return flexSvc.perfdownload();
		
		}
		
		
    
	

}
