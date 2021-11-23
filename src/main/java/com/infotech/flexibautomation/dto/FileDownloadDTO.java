package com.infotech.flexibautomation.dto;

public class FileDownloadDTO {
	
	private String fileExtension;
	private String fileName;
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public FileDownloadDTO(String fileExtension, String fileName) {
		super();
		this.fileExtension = fileExtension;
		this.fileName = fileName;
	}
	public FileDownloadDTO() {
		super();
	
	}
	@Override
	public String toString() {
		return "FileDownloadDTO [fileExtension=" + fileExtension + ", fileName=" + fileName + "]";
	}	
	

}
