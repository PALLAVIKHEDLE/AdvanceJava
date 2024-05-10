package com.training;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root@123");
			String firstName = "";
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String orderID="";
			String itemName="";
			String purchaseDate="";
			String amount="";
			
			List<String[]> orders = new ArrayList<>();
			if (null != userName && null != password) {
				if (connection != null) {
					PreparedStatement statement = connection
							.prepareStatement("select * from registration where userName=? and password=?");
					statement.setString(1, userName);
					statement.setString(2, password);
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						firstName = resultSet.getString(1);
					}
					
					
					PreparedStatement orderStatement = connection
							.prepareStatement("select * from orderDetails");
					ResultSet orderSet = orderStatement.executeQuery();	
					while (orderSet.next()) {
						orderID = orderSet.getString(1);
						itemName = orderSet.getString(2);
						purchaseDate = orderSet.getString(3);
						amount = orderSet.getString(4);
						
						 // Create a String array to represent an order and add to orders list
                        String[] orderData = {orderID, itemName, purchaseDate, amount};
                        orders.add(orderData);
					}
				}
			}
			HttpSession session = request.getSession();
			if (firstName.length() != 0) {
				session.setAttribute("userName", userName);
				session.setAttribute("orders", orders);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("SuccessPage.jsp");
				requestDispatcher.forward(request, response);
			} else {
				session.setAttribute("error", "Invalid Login");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(request, response);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}