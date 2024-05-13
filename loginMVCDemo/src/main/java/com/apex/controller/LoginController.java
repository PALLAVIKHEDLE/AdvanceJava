package com.apex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.apex.bean.UserBean;
import com.apex.service.UserService;
import com.apex.util.UserUtil;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	private UserService userService = new UserService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error = UserUtil.validateRequest(request);
		HttpSession session = request.getSession();
		if (error == null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean(userName, password);
			error = userService.authenticateAndPopulateUser(userBean);
			if (error == null) {
				session.setAttribute("firstName", userBean.getFirstName());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("successPage.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		session.setAttribute("error", error);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
		requestDispatcher.forward(request, response);

	}

}
