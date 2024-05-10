package com.training;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection connection=null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root@123");
				System.out.println(connection);
				
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				

	            // Check if connection is established
	            if (connection != null) {
	                // Check if user already exists in the database
	                PreparedStatement checkStatement = connection.prepareStatement("SELECT * FROM registration WHERE userName = ?");
	                checkStatement.setString(1, userName);
	                ResultSet resultSet = checkStatement.executeQuery();

	                if (resultSet.next()) {
	                    // User already exists, handle this case
	                	 HttpSession session = request.getSession();
					      session.setAttribute("error", "User already exists, try with new user");
					      session.setAttribute("existingUsername", userName);
					      RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.jsp");
					      requestDispatcher.forward(request, response);
	                } else {
	                    // User does not exist, proceed with registration
	                	PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");
						statement.setString(1, firstName);
						statement.setString(2, lastName);
						statement.setString(3, userName);
						statement.setString(4, password);
						
						  int rowsInserted = statement.executeUpdate();
						  response.setContentType("text/html");
	                    // Execute the insert operation

	                    if (rowsInserted > 0) {
	                        // Registration successful, forward to login page
	                        HttpSession session = request.getSession();
	                        session.setAttribute("userName", userName);
	                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegistrationSuccess.jsp");
						      requestDispatcher.forward(request, response);
	                    } else {
	                        // Registration failed
	                        HttpSession session = request.getSession();
	                        session.setAttribute("error", "Registration failed");
	                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.jsp");
						      requestDispatcher.include(request, response);
	                    }
	                    statement.close(); // Close the PreparedStatement
	                }

	                checkStatement.close(); 
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
