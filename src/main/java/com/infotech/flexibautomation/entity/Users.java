package com.infotech.flexibautomation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Integer id;
		
		@Column(name = "username")
		private String userName;
		
		@Column(name = "email_id")
		private String emailId;
		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		@Column(name = "contact_num")
		private String contactNum;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "project_name")
		private String projectName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getContactNum() {
			return contactNum;
		}

		public void setContactNum(String contactNum) {
			this.contactNum = contactNum;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public Users(Integer id, String userName, String emailId, String firstName, String lastName, String contactNum,
				String password, String projectName) {
			super();
			this.id = id;
			this.userName = userName;
			this.emailId = emailId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.contactNum = contactNum;
			this.password = password;
			this.projectName = projectName;
		}

		public Users() {
			super();
		}

		@Override
		public String toString() {
			return "Users [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", contactNum=" + contactNum + ", password=" + password
					+ ", projectName=" + projectName + "]";
		}
		
		
		
	}

			


