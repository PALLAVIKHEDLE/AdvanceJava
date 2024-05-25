package com.learn.service;

import java.sql.SQLException;

import com.learn.bean.UserBean;
import com.learn.constants.UserConstants;
import com.learn.dao.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public String authenticateAndPopulateUser(UserBean userBean) {
		String error = null;

		userBean = userDAO.getUserBean(userBean);

		if (userBean.getFirstName() == null) {
			error = UserConstants.INVALID_USER_CREDENTIALS;
		}

		return error;
	}

	public String registerUser(UserBean userBean) {
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
