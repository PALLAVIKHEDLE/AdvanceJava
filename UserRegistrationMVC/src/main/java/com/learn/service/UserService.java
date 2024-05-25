package com.learn.service;

import com.learn.bean.UserBean;
import com.learn.constants.UserConstants;
import com.learn.dao.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public String authenticateAndPopulateUser(UserBean userBean) {
		String error = null;

		userBean = UserDAO.getUserBean(userBean);

		if (userBean.getFirstName() == null) {
			error = UserConstants.INVALID_USER_CREDENTIALS;
		}

		return error;
	}
}
