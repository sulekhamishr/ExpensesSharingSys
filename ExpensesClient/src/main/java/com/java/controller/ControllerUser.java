package com.java.controller;

import java.sql.Date;
import java.time.LocalDate;

import com.java.dao.UsersDao;
import com.java.model.Users;

public class ControllerUser {

	private UsersDao usersDao;	
	private Users users;

		
		
		public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

		public String registerUser(Users users) {
		    // Set current date
		    users.setCreatedAt(Date.valueOf(LocalDate.now()));

		    // Save to DB via DAO
		    boolean success = usersDao.registerUser(users);
		    
		    if (success) {
		        return "successPage";  // your next page
		    } else {
		        return "errorPage";    // or handle error
		    }
		}

		public String Login(Users user) {
			
			return usersDao.Login(user);
			
		}

	
	
	
	
	
}
