package com.learn.controller;

import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserBean userBean = new UserBean(firstName, lastName, userName, password);
		String error = userService.registerUser(userBean);

		HttpSession session = request.getSession();
		if (error == null) {
			session.setAttribute("userName", userName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegistrationSuccess.jsp");
			requestDispatcher.forward(request, response);
		} else {
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
