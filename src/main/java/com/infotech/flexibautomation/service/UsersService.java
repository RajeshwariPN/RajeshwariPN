package com.infotech.flexibautomation.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infotech.flexibautomation.dto.LoginDto;
import com.infotech.flexibautomation.dto.ReportResponseDto;
import com.infotech.flexibautomation.dto.UsersDto;
import com.infotech.flexibautomation.entity.Users;
import com.infotech.flexibautomation.repo.UsersRepo;

@Service
@Transactional
public class UsersService {
	
	@SuppressWarnings("unused")
	@Autowired
	private UsersRepo usersRepo;

	public ResponseEntity<ReportResponseDto> getUsers(UsersDto usersDto) {
		
		ReportResponseDto response = new ReportResponseDto();
		
		if(usersDto.getUserName()!=null && isUserContainsSpecialChar(usersDto.getUserName()) ) {
			response.setStatus(500);
			response.setMessage("Please enter the valid username");
			return ResponseEntity.ok().body(response);
		}
		
		Users user = usersRepo.getByUserName(usersDto.getUserName());
		
		if(user != null) {
			response.setStatus(500);
			response.setMessage("User name already exists");
			return ResponseEntity.ok().body(response);
		}
		
       Users user2 = usersRepo.getByContactNum(usersDto.getContactNum());
		
		if(user2 != null) {
			response.setStatus(500);
			response.setMessage("Contact number already exists");
			return ResponseEntity.ok().body(response);
		}     
		
       Users user1 = usersRepo.getByEmailId(usersDto.getEmailId());
		
		if(user1 != null) {
			response.setStatus(500);
			response.setMessage("Email id already exists");
			return ResponseEntity.ok().body(response);
		}
		
		if(!isValidMobileNo(usersDto.getContactNum())){
			response.setStatus(500);
			response.setMessage("Please check the entered data");
			return ResponseEntity.ok().body(response);
		}
		
		if(usersDto.getEmailId()!=null && !isValidEmail(usersDto.getEmailId()) ) {
			response.setStatus(500);
			response.setMessage("Please enter the valid email id");
			return ResponseEntity.ok().body(response);
		}
		
		if(usersDto.getFirstName()!=null && isUserContainsSpecialChar(usersDto.getFirstName()) ) {
			response.setStatus(500);
			response.setMessage("Please enter the valid firstname");
			return ResponseEntity.ok().body(response);
		}
		
		if(usersDto.getLastName()!=null && isUserContainsSpecialChar(usersDto.getLastName()) ) {
			response.setStatus(500);
			response.setMessage("Please enter the valid lastname");
			return ResponseEntity.ok().body(response);
		}
		
	Users newUser =  new Users();
	newUser.setUserName(usersDto.getUserName());
	newUser.setEmailId(usersDto.getEmailId());
	newUser.setFirstName(usersDto.getFirstName());
	newUser.setLastName(usersDto.getLastName());
	newUser.setContactNum(usersDto.getContactNum());
	newUser.setPassword(passwordEncrypt(usersDto.getPassword()));
	newUser.setProjectName(usersDto.getProjectName());
	usersRepo.save(newUser);
	
		response.setStatus(200);
		response.setMessage("User Created successfully");
		return ResponseEntity.ok().body(response);
	}
	
	public String passwordEncrypt(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedPassword;
	}

	
	public static boolean isValidMobileNo(String str)  {  
		Pattern ptrn = Pattern.compile("[1-9][0-9]{9}");  
		Matcher match = ptrn.matcher(str);  
		return (match.find() && match.group().equals(str));   
	}
	
	public static boolean isUserContainsSpecialChar(String str)  {  
		Pattern ptrn = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);  
		Matcher match = ptrn.matcher(str);  
		return match.find();   
	 }
	
	public static boolean isValidEmail(String str)  {  
		Pattern ptrn = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$", Pattern.CASE_INSENSITIVE);  
		Matcher match = ptrn.matcher(str);  
		return match.find();   
	 }

	@Transactional
	public ResponseEntity<ReportResponseDto> getUsersLogin(LoginDto loginDto) {
		ReportResponseDto responce = new ReportResponseDto();
		Users user = usersRepo.findByUserName(loginDto.getUserName());
		if(user == null) {
			responce.setStatus(500);
			responce.setMessage("User not exist with given username");
			return ResponseEntity.ok().body(responce);
		}
		
		String encryptRecivedPass =  passwordEncrypt(loginDto.getPassword());
		
		if(!user.getPassword().equals(encryptRecivedPass)) {
			responce.setStatus(500);
			responce.setMessage("Enter valid password");
			return ResponseEntity.ok().body(responce);
			
		}
		
		if(!user.getProjectName().equalsIgnoreCase(loginDto.getProjectName())) {
			responce.setStatus(500);
			responce.setMessage("Project is not assigened to enterd user");
			return ResponseEntity.ok().body(responce);
			
		}
		
		responce.setStatus(200);
		responce.setMessage("Logged In Succefully");
		return ResponseEntity.ok().body(responce);
	}
	
	
}
