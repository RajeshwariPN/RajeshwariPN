package com.infotech.flexibautomation.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadService {

	private static final String ZIP_FILE_LOCATION = "F:\\Flexib_FileDownload";
	//private static final String JMX_FILE_LOCATION = "D:\\FileDownload\\shoppingcartcode\\shoppingcartcode\\apache-jmeter-5.1.1\\apache-jmeter-5.1.1\\sampleProject";
	private static final String JMX_FILE_LOCATION = "F:\\Flexib_FileDownload";
	public ResponseEntity<Resource> getFileDownload(String fileName, String fileExtension) {

		File file = null;
		if (fileExtension.equalsIgnoreCase("Zip"))
			file = new File(ZIP_FILE_LOCATION + "\\" + fileName + "." + fileExtension);
		else
			file = new File(JMX_FILE_LOCATION + "\\" + fileName + "." + fileExtension);

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + "." + fileExtension);
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = null;

		try {
			resource = new ByteArrayResource(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().headers(header).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}
	


}
