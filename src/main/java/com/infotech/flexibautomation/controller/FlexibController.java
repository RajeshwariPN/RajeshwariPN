package com.infotech.flexibautomation.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

import com.infotech.flexibautomation.dto.AvokaResponseDto;
import com.infotech.flexibautomation.dto.CheckoutGithubAccessTokenDTO;
import com.infotech.flexibautomation.dto.EmployeeDetailsDto;
import com.infotech.flexibautomation.dto.ExcelHeaders;
import com.infotech.flexibautomation.dto.GithubUpload;
import com.infotech.flexibautomation.dto.JmeterCommandDTO;
import com.infotech.flexibautomation.dto.LoginDto;
import com.infotech.flexibautomation.dto.MavenCommandPropmtDTO;
import com.infotech.flexibautomation.dto.MobileAutomation;
import com.infotech.flexibautomation.dto.PerfDashboardCountDTO;
import com.infotech.flexibautomation.dto.PerformanceDashboardErrorCountDTO;
import com.infotech.flexibautomation.dto.PersonalDetailsDto;
import com.infotech.flexibautomation.dto.ReportFind;
import com.infotech.flexibautomation.dto.ReportResponseDto;
import com.infotech.flexibautomation.dto.ResponseDto;
import com.infotech.flexibautomation.dto.ResponseExel;
import com.infotech.flexibautomation.dto.SearchCriteriaDTO;
import com.infotech.flexibautomation.dto.SecurityCodeQualityDto;
import com.infotech.flexibautomation.dto.SecurityDto;
import com.infotech.flexibautomation.dto.UsersDto;
import com.infotech.flexibautomation.dto.VisualAutoApproveDto;
import com.infotech.flexibautomation.dto.VisualAutoInitDto;
import com.infotech.flexibautomation.service.AvokaResultsService;
import com.infotech.flexibautomation.service.EmployeeDetailsService;
import com.infotech.flexibautomation.service.FileDownloadService;
import com.infotech.flexibautomation.service.PerformanceDashboardService;
import com.infotech.flexibautomation.service.PersonalDetailsService;
import com.infotech.flexibautomation.service.SecurityCodeQualityService;
import com.infotech.flexibautomation.service.SecurityService;
import com.infotech.flexibautomation.service.UsersService;
import com.infotech.flexibautomation.service.VisualAutoApproveDeclineService;
import com.infotech.flexibautomation.service.VisualAutoCreateRefService;
import com.infotech.flexibautomation.service.VisualAutoInitService;

@RestController
public class FlexibController {

	
	@Autowired
	private AvokaResultsService avokaResultsService;
	
	@Autowired
	private PerformanceDashboardService performanceDashboardService;
	
	@Autowired
	private FileDownloadService fileDownloadService;
	
	@Autowired
	private VisualAutoInitService visualAutoInitService;
	
	@Autowired
	private VisualAutoCreateRefService visualAutoCreateRefService; 
	
	@Autowired
	private VisualAutoApproveDeclineService visualAutoApproveDeclineService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SecurityCodeQualityService securityCodeQualityService;
	
	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	private UsersService usersService;
	
	
	//Automation Dashboard API - Data from database
	@PostMapping(value = "/avokaResults")
	public AvokaResponseDto getAvokaResults(@RequestBody SearchCriteriaDTO criteria){
		return avokaResultsService.getAvokaResults(criteria);
	}
	
	
	//API for file download
	
	@GetMapping(value = "/getFileDownload")
	public  ResponseEntity<Resource> getFileDownload(@RequestParam String fileName, @RequestParam String fileExtension ) {
		return fileDownloadService.getFileDownload(fileName,fileExtension);
	}
		
	
	//API for performance dashboard count Jmeter results
	
	@PostMapping(value = "/getDateRangeStatusCountPerformanceDashboard")
	public PerformanceDashboardErrorCountDTO getTotalCount(@RequestBody PerfDashboardCountDTO criteria) {
		return performanceDashboardService.getStatusCount(criteria);
	}
	
	//API for Visual Automation screen Initialize
	
	
	@PostMapping(value = "/visualauto/initialize")
	public  ResponseEntity<ResponseDto> getcreateInit(@RequestBody VisualAutoInitDto visualAutoInit )  {
	return visualAutoInitService.getcreateInit(visualAutoInit);
	}
		
	//API For Visual Auto Create reference
			
	@PostMapping(value = "/visualauto/createref")
	public  ResponseEntity<ResponseDto> getcreateReference(@RequestBody VisualAutoApproveDto visualAutoApproveDto )  {
	return visualAutoCreateRefService.getcreateReference(visualAutoApproveDto);
	}
	
	//API For Visual Auto Create reference
	
	@PostMapping(value = "/visualauto/approve")
	public ResponseEntity<ResponseDto> getcreateApprove(@RequestBody VisualAutoApproveDto criteria) {
		return visualAutoApproveDeclineService.getcreateApprove(criteria);
	}
	
	//API for Security code ananysis using sonar scanner
	
	@PostMapping(value = "/sonar/security/codeanalysis")
	public ResponseEntity<ResponseDto> getsecurityService(@RequestBody SecurityDto securityDto) throws IOException {
		return securityService.getsecurityService(securityDto);
		}
	
	//API for Security code ananysis using sonar scanner
	
	@PostMapping(value = "/sonar/security/codequality")
	public ResponseEntity<ResponseDto> getcodeQuality(@RequestBody SecurityCodeQualityDto SecurityCodeQualityDto){ 
		return securityCodeQualityService.getcodeQuality(SecurityCodeQualityDto);
		}
	
	
	@PostMapping(value = "/validate/PersonalDetails")
	public ResponseEntity<ReportResponseDto> getPersonalDetails(@RequestBody PersonalDetailsDto PersonalDetailsDto){ 
		return personalDetailsService.getPersonalDetails(PersonalDetailsDto);
		}
	
	//API for Employee details demo
	
	@PostMapping(value = "/validate/EmpDetails")
	public ResponseEntity<ReportResponseDto> getEmployeeDetails(@RequestBody EmployeeDetailsDto employeeDetailsDto){ 
	return employeeDetailsService.getEmployeeDetails(employeeDetailsDto);
			}
	
	//API for Users Creation
	
	@PostMapping(value = "/users/creation")
	public ResponseEntity<ReportResponseDto> getUsers(@RequestBody UsersDto usersDto){ 
	return usersService.getUsers(usersDto);
			}
			
	//API for login 
			
	@PostMapping(value = "/users/login")
	public ResponseEntity<ReportResponseDto> getUsersLogin(@RequestBody LoginDto loginDto){ 
	return usersService.getUsersLogin(loginDto);
		}
	
	
	//Execute API - Execute button on Automation page (mvn clean test)
	
	@PostMapping("/execute/maven")
	public ResponseEntity<String> getExecuteMavneCmd(@RequestBody MavenCommandPropmtDTO mavenCommandPropmtDTO) throws IOException
	{
	mavenCommandPropmtDTO.setMavenCommand(mavenCommandPropmtDTO.getMavenCommand());
	mavenCommandPropmtDTO.setProjectPath(mavenCommandPropmtDTO.getProjectPath());
	ProcessBuilder builder = new ProcessBuilder(
	"cmd.exe", "/c", "cd " + mavenCommandPropmtDTO.getProjectPath() + " && " + mavenCommandPropmtDTO.getMavenCommand());
	//System.out.println("cd " + mavenCommandPropmtDTO.getProjectPath() + " && " + mavenCommandPropmtDTO.getMavenCommand());
	builder.redirectErrorStream(true);
	Process p = builder.start();
	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String line;
	StringBuilder sbuilder=new StringBuilder();
	while (true) {
	line = r.readLine();
	if (line == null)
	{
	break;
	}
	sbuilder=sbuilder.append(line);
	sbuilder.append(System.lineSeparator());
	}
	System.out.println(sbuilder);
	return new ResponseEntity<String>(sbuilder.toString(),HttpStatus.OK);
	}

	/*@GetMapping("/execute/maven")
	public String getExecuteMavneCmd() throws IOException
	{
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", "/c", "cd \"F:\\STS_Workspace_Flexib2.0\\WebAutomationTesting\" && mvn clean test");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		StringBuilder sbuilder=new StringBuilder();
		while (true) {

			line = r.readLine();
			if (line == null) 
			{ 
				break; 
			}
			sbuilder=sbuilder.append(line);
			sbuilder.append(System.lineSeparator());		
		}
		//System.out.println("Done");
		System.out.println(sbuilder);
		return sbuilder.toString();
	}*/

	//Performance Page execute with Performance parameters API
	@PostMapping("/execute/jmeter")
	public ResponseEntity<String> getExecuteJmeterCmd(@RequestBody JmeterCommandDTO jmeterCommandDTO) throws IOException
	{
	String path="F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin";
	String jmcmd="dir";
	
	jmeterCommandDTO.setjServerUrl(jmeterCommandDTO.getjServerUrl());
	jmeterCommandDTO.setjPorntNo(jmeterCommandDTO.getjPorntNo());
	jmeterCommandDTO.setjUserCount(jmeterCommandDTO.getjUserCount());
	jmeterCommandDTO.setjDuration(jmeterCommandDTO.getjDuration());
	jmeterCommandDTO.setjRampUp(jmeterCommandDTO.getjRampUp());
	jmeterCommandDTO.setjRampDown(jmeterCommandDTO.getjRampDown());

	ProcessBuilder builder = new ProcessBuilder(
	//"cmd.exe", "/c", "cd \"C:\\Temp\\Unified Functional Testing\" && dir");
	//"cmd.exe", "/c", "cd " + path + " && " + jmcmd);

	 "cmd.exe", "/c", "cd \"F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin\" && jmeter.bat -n -t F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin\\sampleProject\\OnlineShoppingCartFWK.jmx"+ " -JSERVERURL="+jmeterCommandDTO.getjServerUrl()+" -JPORTNO="+jmeterCommandDTO.getjPorntNo()+
	" -JUSERCOUNT="+jmeterCommandDTO.getjUserCount()+" -JDURATION="+jmeterCommandDTO.getjDuration()+" -JRAMPUP="+jmeterCommandDTO.getjRampUp()+
	" -JRAMPDOWN="+jmeterCommandDTO.getjRampDown()+" -l F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin\\sampleProject\\Result.jtl -e -o F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin\\sampleProject\\Report");

	builder.redirectErrorStream(true);
	Process p = builder.start();
	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String line;
	StringBuilder sbuilder=new StringBuilder();
	while (true) {
	line = r.readLine();
	if (line == null)
	{
	break;
	}
	sbuilder=sbuilder.append(line);
	sbuilder.append(System.lineSeparator());

	FileWriter fw = new FileWriter("F:\\FlexibPerformanceTesting\\apache-jmeter-5.4.1\\bin\\sampleProject\\ExecutionLog\\jmeterCmd.txt",true);
	PrintWriter out = new PrintWriter(fw);

	// Append the name of ocean to the file
	out.println(sbuilder);

	// Close the file.
	out.close();

		}
	return new ResponseEntity<String>(sbuilder.toString(),HttpStatus.OK);
	}
	
	

	//API  for cloning git
	@PostMapping("/checkout/github")
	public String getCheckoutGitHub(@RequestBody CheckoutGithubAccessTokenDTO checkoutGithubAccessTokenDTO) throws IOException
	{
	System.out.println(checkoutGithubAccessTokenDTO.getCloneDirectoryPath());
	//File localPath = File.createTempFile(checkoutGithubAccessTokenDTO.getCloneDirectoryPath(), "");
	//localPath.delete();
	if(checkoutGithubAccessTokenDTO!=null)
	{
	try {
	String url[] = new String[2];
	url = checkoutGithubAccessTokenDTO.getRepositoryUrl().split("://");
	if(url.length==2)
	{
	String repoUrl = url[0]+"://"+checkoutGithubAccessTokenDTO.getAccessToken()+"@"+url[1];
	CloneCommand command = Git.cloneRepository();
	command.setURI(repoUrl);
	command.setCredentialsProvider(new UsernamePasswordCredentialsProvider("username",checkoutGithubAccessTokenDTO.getAccessToken()));
	command.setDirectory(Paths.get(checkoutGithubAccessTokenDTO.getCloneDirectoryPath()).toFile()) .call();
	System.out.println("Completed Cloning"); }else {
	System.out.println("Invalid Repository URL");
	}
	}
	catch (GitAPIException e) {
	System.out.println("Invalid credentials");
	e.printStackTrace();
	return "Cloning Failed";
	}
	}
	return "Cloning Completed";
	}
	
	//GitHub Upload API
	
	/*@PostMapping("/gitupload/repo")
	public Response<String> getrepoUpload(@RequestBody GithubUpload GithubUpload) throws Exception
	{
		String gitlocalpath=GithubUpload.getprojectPath();
		GithubUpload.setprojectPath(GithubUpload.getprojectPath());
		GithubUpload.setaccessToken(GithubUpload.getaccessToken());
		GithubUpload.setrepoURL(GithubUpload.getrepoURL());
		
		String url[] = new String[2];
		url = GithubUpload.getrepoURL().split("://");
		
		String gitrepoUrl1 = url[0]+"://"+GithubUpload.getaccessToken()+"@"+url[1];
		System.out.println(gitrepoUrl1);
		String ddd="git remote add origin "+gitrepoUrl1+"";
		System.out.print(ddd);
		String[] gituploadcmds = {"git init","git remote add origin "+gitrepoUrl1+"","git add .","git commit -m \"first commit\"","git push -u origin master"}; 
		try {
	        for(String gituploadcmd : gituploadcmds) {
	            execute(gituploadcmd,gitlocalpath);
	        }
           }catch (Exception e) {
        		System.out.println("Failed to upload Local folder");
        		e.printStackTrace();
	       return new ResponseEntity<String>(sbuilder.toString(),HttpStatus.OK);
	}
	        
	public static void execute(String gituploadcmd,String gitlocalpath) throws IOException, Exception {
       // ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","cd \"D:\\Gituploadsample\"&&"+gituploadcmd);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","cd "+gitlocalpath+"&&"+gituploadcmd);
        Process process = builder.inheritIO().start();
       Thread.sleep(5000);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String readline;
        while ((readline = reader.readLine()) != null) {
            System.out.println(readline);
        }


	}*/
	
	@PostMapping("/gitupload/repo")
	public String getrepoUpload(@RequestBody GithubUpload GithubUpload) throws Exception
	{
		String gitlocalpath=GithubUpload.getprojectPath();
		GithubUpload.setprojectPath(GithubUpload.getprojectPath());
		GithubUpload.setaccessToken(GithubUpload.getaccessToken());
		GithubUpload.setrepoURL(GithubUpload.getrepoURL());
		
		String url[] = new String[2];
		url = GithubUpload.getrepoURL().split("://");
		
		String gitrepoUrl1 = url[0]+"://"+GithubUpload.getaccessToken()+"@"+url[1];
		System.out.println(gitrepoUrl1);
		String ddd="git remote add origin "+gitrepoUrl1+"";
		System.out.print(ddd);
		String[] gituploadcmds = {"git init","git remote add origin "+gitrepoUrl1+"","git add .","git commit -m \"first commit\"","git push -u origin master"}; 
		try {
	        for(String gituploadcmd : gituploadcmds) {
	           boolean status = execute(gituploadcmd,gitlocalpath);
	           
	           if(!status) {
	        	   return "File Uploaded fail,already exist in remote";
	           }
	        }
	       
           }catch (Exception e) {
        		System.out.println("Failed to upload Local folder");
        		e.printStackTrace();
        		return " Failed to upload file";
	        }
		 return " Fileuploaded Successfully";
	}
	        
	public static boolean execute(String gituploadcmd,String gitlocalpath)  {
       // ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","cd \"D:\\Gituploadsample\"&&"+gituploadcmd);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","cd "+gitlocalpath+"&&"+gituploadcmd);
        Process process;
		try {
			process = builder.inheritIO().start();
			System.out.println(process.getErrorStream());
			System.out.println(process.getInputStream());
			System.out.println(process.getOutputStream());
			Thread.sleep(5000);
		    process.waitFor();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    String readline;
		        while ((readline = reader.readLine()) != null) {
		            System.out.println(readline);
		        }
		    return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	@PostMapping("/execute/mobileautomation")
	public ResponseEntity<String> getExecuteMobileAuto(@RequestBody MobileAutomation mobileAutomation) throws IOException
	{
		mobileAutomation.setprojectPath(mobileAutomation.getprojectPath());
		mobileAutomation.setdeviceName(mobileAutomation.getdeviceName());
		mobileAutomation.setosversion(mobileAutomation.getosversion());
		mobileAutomation.setplatformName(mobileAutomation.getplatformName());
		mobileAutomation.setbrowserName(mobileAutomation.getbrowserName());
		mobileAutomation.setuserName(mobileAutomation.getuserName());
		mobileAutomation.setaccesskey(mobileAutomation.getaccesskey());
		mobileAutomation.settestName(mobileAutomation.gettestName());
		mobileAutomation.setbuildName(mobileAutomation.getbuildName());

	ProcessBuilder builder = new ProcessBuilder(
	//"cmd.exe", "/c", "cd \"C:\\Temp\\Unified Functional Testing\" && dir");
   // "cmd.exe", "/c", "cd " + mobileAutomation.getprojectPath() + " && " + "mvn clean test"+" -DdeviceName=\"\"Android GoogleAPI Emulator\""+" -Dosversion="+mobileAutomation.getosversion()+" -DplatformName"+mobileAutomation.getplatformName()+" -DbrowserName="+mobileAutomation.getbrowserName()+" -DuserName="+mobileAutomation.getuserName()+" -Daccesskey"+mobileAutomation.getaccesskey()+" -DtestName="+mobileAutomation.gettestName()+" -Dbuild="+mobileAutomation.getbuildName());
		//	"cmd.exe", "/c", "cd " + mobileAutomation.getprojectPath() + " && " + "mvn clean test"+" -DdeviceName="+mobileAutomation.getdeviceName()+" -Dosversion="+mobileAutomation.getosversion()+" -DplatformName"+mobileAutomation.getplatformName()+" -DbrowserName="+mobileAutomation.getbrowserName()+" -DuserName="+mobileAutomation.getuserName()+" -Daccesskey"+mobileAutomation.getaccesskey()+" -DtestName="+mobileAutomation.gettestName()+" -Dbuild="+mobileAutomation.getbuildName());
	"cmd.exe", "/c", "cd " + mobileAutomation.getprojectPath() + " && " + "mvn clean test"+" -DdeviceName="+"\""+mobileAutomation.getdeviceName()+"\""+" -Dosversion="+mobileAutomation.getosversion()+" -DplatformName="+mobileAutomation.getplatformName()+" -DbrowserName="+mobileAutomation.getbrowserName()+" -DuserName="+mobileAutomation.getuserName()+" -Daccesskey="+mobileAutomation.getaccesskey()+" -DtestName="+mobileAutomation.gettestName()+" -Dbuild="+mobileAutomation.getbuildName());
			builder.redirectErrorStream(true);
	Process p = builder.start();
	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String line;
	StringBuilder sbuilder=new StringBuilder();
	while (true) {
	line = r.readLine();
	if (line == null)
	{
	break;
	}
	sbuilder=sbuilder.append(line);
	sbuilder.append(System.lineSeparator());
	}
	System.out.println(sbuilder);
	return new ResponseEntity<String>(sbuilder.toString(),HttpStatus.OK);
	}
	/*
	@PostMapping("/report/find")
	public String getreportfind(@RequestBody ReportFind ReportFind) throws Exception
	{
		ReportFind.setprojectPath(ReportFind.getprojectPath());
		ReportFind.setreportname(ReportFind.getreportname());
		ReportFind.setreposubpath(ReportFind.getreposubpath());
		String chromepath="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		// File directoryPath = new File(ReportFind.getprojectPath()+"\\target\\surefire-reports");
		File directoryPath = new File(ReportFind.getprojectPath()+ReportFind.getreposubpath());
		System.out.println(directoryPath);
		//List of all files and directories
		File filesList[] = directoryPath.listFiles();
		System.out.println("List of files and directories in the specified directory:");
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;
		for(File file : filesList) {
		if(file.getName().contains(ReportFind.getreportname()))
		{
		if (file.lastModified() > lastModifiedTime)
		{
		chosenFile = file;
		lastModifiedTime = file.lastModified();
		}
		}
		}
		System.out.println(chosenFile);
		Runtime rTime = Runtime.getRuntime();
		String url = chosenFile.getAbsoluteFile().toString();
		String browser =chromepath;
		Process pc = rTime.exec(new String[]{browser, url});
		System.out.println(url);
		String AutomateType="MobileAutomation";
		String fpath;
		String reporpath;
		if(AutomateType=="WebAutomation") {
		fpath="http://14.99.175.107:17656";
		reporpath=fpath+"/Reports/WebAutomationTesting/"+ReportFind.getreportname();
	    return reporpath.toString();
		}
		else if(AutomateType=="MobileAutomation") {
		fpath="http://14.99.175.107:17656";
		reporpath=fpath+"/Reports/MobileAutomation/"+ReportFind.getreportname();
		return reporpath.toString();
		}
		return "report not available";
	}*/
	
	
	@PostMapping("/report/find")
	public ResponseEntity<ReportResponseDto> getreportfind(@RequestBody ReportFind ReportFind) throws Exception
	{
		ReportFind.setprojectPath(ReportFind.getprojectPath());
		ReportFind.setreportname(ReportFind.getreportname());
		ReportFind.setreposubpath(ReportFind.getreposubpath());
		
		String chromepath="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		// File directoryPath = new File(ReportFind.getprojectPath()+"\\target\\surefire-reports");
		
		ReportResponseDto response = new ReportResponseDto();
		File directoryPath = new File(ReportFind.getprojectPath()+ReportFind.getreposubpath());
		if(!directoryPath.exists()){
			response.setStatus(500);
			response.setMessage("Invalid Path");
			return ResponseEntity.ok().body(response); 
			}	
		System.out.println(directoryPath);
		//List of all files and directories
		File filesList[] = directoryPath.listFiles();
		System.out.println("List of files and directories in the specified directory:");
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;
		for(File file : filesList) {
		if(file.getName().contains(ReportFind.getreportname()))
		{
		if (file.lastModified() > lastModifiedTime)
		{
		chosenFile = file;
		lastModifiedTime = file.lastModified();
		}
		}
		}
		System.out.println(chosenFile);
		Runtime rTime = Runtime.getRuntime();
		String url = chosenFile.getAbsoluteFile().toString();
		String browser =chromepath;
		Process pc = rTime.exec(new String[]{browser, url});
		System.out.println(url);
		String AutomateType="MobileAutomation";
		String fpath;
		String reporpath;
		if(AutomateType=="WebAutomation") {
		fpath="http://14.99.175.107:17656";
		reporpath=fpath+"/Reports/WebAutomationTesting/"+ReportFind.getreportname();
		
		response.setStatus(200);
		response.setMessage(reporpath);
		return ResponseEntity.ok().body(response); 
		}
		else if(AutomateType=="MobileAutomation") {
		fpath="http://14.99.175.107:17656";
		reporpath=fpath+"/Reports/MobileAutomation/"+ReportFind.getreportname();
		
		response.setStatus(200);
		response.setMessage(reporpath);
		return ResponseEntity.ok().body(response); 
		}
		response.setStatus(500);
		response.setMessage("Report Not Available");
		return ResponseEntity.ok().body(response); 
	}
	
	@PostMapping("/execute/exceldataupdate")
	public ResponseEntity<ResponseExel> excelDataUpdate(@RequestBody ArrayList<List<Object>> data) throws IOException, InvalidFormatException, ParseException
	{
		ResponseExel response=new ResponseExel();

	ArrayList<ExcelHeaders> input_data = new ArrayList<>();
	String input_filepath = "F:\\exceldataupdate\\AppiumReportFormat.xlsx";
	for (List<Object> list : data) {
	for (Object list2 : list) {
	System.out.println(list2);
	String[] strArray= list2.toString().split(",");
	 Map<String, String> map = new HashMap<>();
	 for (String pair : strArray) {
	 String split[] = pair.split("=");
	 //System.out.println(split[0]);
	 //System.out.println(split[1]);
	 if(split[0].contains("{"))
	 {
	 map.put(split[0].trim().substring(1), split[1].trim());
	 }else if(split[1].contains("}"))
	 {
	 StringBuffer sb= new StringBuffer(split[1].trim()); 
	 //invoking the method
	 map.put(split[0].trim(), sb.deleteCharAt(sb.length()-1).toString());
	 }else
	 {
	 map.put(split[0].trim(), split[1].trim());
	 }
	 //System.out.println(map.get(split[0]));
	 
	 }
	 ExcelHeaders obj = new ExcelHeaders();
	obj.setTestCase_Id(map.get("TestCase_Id"));
	obj.setTestCaseName(map.get("Test case name"));
	obj.setTestDesc(map.get("Test Desc"));
	obj.setTestScriptName(map.get("Test Script Name"));
	obj.setRunMode(map.get("Run_Mode"));
	input_data.add(obj);
	System.out.println(obj.getTestCase_Id());
	}
	response.setMsg("your data has been updated successfully");
	}

	insertIntoExcel(input_data,input_filepath);

	return new ResponseEntity<ResponseExel>(response, HttpStatus.OK);
	}



	private void insertIntoExcel(List<ExcelHeaders> mailList,String input_filepath) throws ParseException, IOException, InvalidFormatException
	{ 

	FileInputStream fis=new FileInputStream(new File(input_filepath));
	XSSFWorkbook hssfWorkbook = new XSSFWorkbook(fis);
	//spreadsheet object
	XSSFSheet spreadsheet = hssfWorkbook.getSheetAt(0);
	//creating a row object
	XSSFRow row;
	//This data needs to be written (Object[])
	Map<Integer, Object[]> mailDetails_map = new TreeMap<Integer, Object[]>();

	mailDetails_map.put(1, new Object[] { "TestCase_Id","Test case name","Test Desc","Test Script Name","Run_Mode"});

	int counter = 2;

	for (ExcelHeaders mailData : mailList) {

	mailDetails_map.put(counter, new Object[] { mailData.getTestCase_Id(),mailData.getTestCaseName(),mailData.getTestDesc(),mailData.getTestScriptName(),mailData.getRunMode()});
	counter++;
	}

	Set<Integer> keyid = mailDetails_map.keySet();
	int rowid = 0;
	//writing the data into the sheets...
	for (Integer key : keyid) {
	row = spreadsheet.createRow(rowid++);
	Object[] objectArr = mailDetails_map.get(key);
	int cellid = 0;

	for (Object obj : objectArr) {
	Cell cell = row.createCell(cellid++);
	cell.setCellValue((String)obj);
	}
	}
	//.xlsx is the format for Excel Sheets...
	//writing the workbook into the file...
	FileOutputStream out = new FileOutputStream(new File(input_filepath));
	System.out.println("File Path:"+input_filepath);
	hssfWorkbook.write(out);
	out.close();
	}

	

	
}
