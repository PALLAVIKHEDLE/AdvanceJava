package com.learn.controller;

import java.io.IOException;
import java.util.List;

import com.learn.bean.OrderBean;
import com.learn.bean.UserBean;
import com.learn.dao.OrderDAO;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

				// Fetch the list of orders
				List<OrderBean> orders = OrderDAO.getAllOrders();
				session.setAttribute("orderList", orders);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("SuccessPage.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		session.setAttribute("error", error);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
		requestDispatcher.forward(request, response);
	}
}
