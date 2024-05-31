package com.apex.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.apex.beans.User;
import com.apex.dao.UserDAO;

@Service
public class UserService {

	private UserDAO userDAO = new UserDAO();

	public String registerUser(User userBean) {
		try {
			// Log the start of the registration process
			System.out.println("Starting registration process for user: " + userBean.getUserName());

			if (userDAO.isUserExists(userBean.getUserName())) {
				System.out.println("User already exists: " + userBean.getUserName());
				return "User already exists, try with new user";
			} else {
				boolean isRegistered = userDAO.registerUser(userBean);
				if (isRegistered) {
					System.out.println("Registration successful for user: " + userBean.getUserName());
					return null;
				} else {
					System.out.println("Registration failed for user: " + userBean.getUserName());
					return "Registration failed";
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLException occurred during registration: " + e.getMessage());
			e.printStackTrace();
			return "An error occurred during registration: " + e.getMessage();
		} catch (Exception e) {
			System.err.println("Exception occurred during registration: " + e.getMessage());
			e.printStackTrace();
			return "An error occurred during registration: " + e.getMessage();
		}
	}

}