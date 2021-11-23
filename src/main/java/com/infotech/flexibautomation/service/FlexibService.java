package com.infotech.flexibautomation.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FlexibService {

public boolean createClone() {
		
	//code for checkout for automation,clonning git project in local using url
	
		System.out.println("%%%%% Inside service");
		//String repoUrl1 ="https://github.com/bhaskarpenmetsa/WebAutomationTesting.git";
		 //String repoUrl1 ="https://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@github.com/bhaskaravarma/WebAutomation.git";
		//String repoUrl1 ="https://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@github.com/bhaskarpenmetsa/WebAutomationTesting.git";
		//String repoUrl1 = "https://RAJESHWARI3I@bitbucket.org/vamsisanagala/flexibui.git";
		String repoUrl1 = "https://github.com/onecompiler/tutorials.git";
		 //String repoUrl1 = "https://github.com/bhaskaravarma/MobileSurefirePluginUpdated.git";
		String cloneDirectoryPath = "D:\\try";
		try {
		    System.out.println("Cloning "+repoUrl1+" into "+repoUrl1);
		    Git.cloneRepository()
		        .setURI(repoUrl1)
		        .setDirectory(Paths.get(cloneDirectoryPath).toFile())
		       // .setCredentialsProvider(new UsernamePasswordCredentialsProvider("rajeshwari.navali@3i-infotech.com", "Padebit@001"))
		        .setCredentialsProvider(new UsernamePasswordCredentialsProvider("bhaskaravaram", "Infotech@2023"))
		        .call();
		    System.out.println("Succefully Completed Cloning");
		    return true;
		} catch (GitAPIException e) {
		    System.out.println("Exception occurred while cloning repo");
		    e.printStackTrace();
		    return false;
		}
		
	}


//Code for downloding file into lacal machine for automation page
	private static final String EXTENSION = ".zip";
    private static final String SERVER_LOCATION = "D:\\Flexib Workspace\\ZipSource\\WebAutomationTesting";

    @RequestMapping(path = "/autodownload", method = RequestMethod.GET)
    public ResponseEntity<Resource> autodownload() throws IOException {
        File file = new File( SERVER_LOCATION  + EXTENSION);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=WebAutomation.zip");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
		
    
    //download file for performance page
    private static final String EXTENSION1 = ".JMX";
    private static final String SERVER_LOCATION1 = "D:\\Flexib Workspace\\shoppingcartcode\\shoppingcartcode\\apache-jmeter-5.1.1\\apache-jmeter-5.1.1\\sampleProject\\OnlineShoppingCartFWK";

    @RequestMapping(path = "/perfdownload", method = RequestMethod.GET)
    public ResponseEntity<Resource> perfdownload() throws IOException {
        File file = new File( SERVER_LOCATION1  + EXTENSION1);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=OnlineShoppingCartFWK.JMX");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    
    }    
}
