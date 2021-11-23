package com.infotech.flexibautomation.dto;

public class VisualAutoInitDto {

private String projectName;

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public VisualAutoInitDto(String projectName) {
	super();
	this.projectName = projectName;
}

public VisualAutoInitDto() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "VisualAutoInitDto [projectName=" + projectName + "]";
}

}
