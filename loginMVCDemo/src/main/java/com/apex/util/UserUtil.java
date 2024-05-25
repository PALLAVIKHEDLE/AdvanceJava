package com.apex.util;

import com.apex.constants.UserConstants;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateRequest(HttpServletRequest request) {
		String error = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.isEmpty() || password.isEmpty()) {
			error = UserConstants.EMPTY_USERNAME_PASSWORD;
		}
		return error;
	}
}
