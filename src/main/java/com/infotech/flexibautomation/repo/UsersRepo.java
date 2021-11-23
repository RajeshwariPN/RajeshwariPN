package com.infotech.flexibautomation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.infotech.flexibautomation.dto.LoginDto;
import com.infotech.flexibautomation.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>, CrudRepository<Users,Integer> {
	
	Users getByUserName(String userName);

	Users getByEmailId(String emailId);

	void save(LoginDto loginDto);

	Users findByUserName(String username);

	Users findByProjectName(String projectName);

	Users getByContactNum(String contactNum);

	
}
