package com.apex.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.springDemo.beans.User;
import com.apex.springDemo.dao.UserDAO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;

	public User addUser(User user) {
		return userDAO.addUser(user) > 0 ? user : null;
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	public String deleteUser(int id) {
		return userDAO.deleteUser(id) > 0 ? "User Deleted" : "Error in Deleting the User";
	}

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

}
