

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class addUser
 */
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection connection = null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			ServletContext servletContext=config.getServletContext();
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(servletContext.getInitParameter("connectionURL"),servletContext.getInitParameter("userName"),servletContext.getInitParameter("password"));
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		System.out.println("Values: " + firstName + " " + lastName + " " + userName + " " + password);
		try {
			Statement statement=connection.createStatement();
			int executeUpdate=statement.executeUpdate("insert into user values('"+firstName+"','"+lastName+"','"+userName+"','"+password+"')");
			
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			if(executeUpdate==1)writer.append("User Added Successfully!");
			else writer.append("Error Adding User.");
			
			writer.close();
			statement.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

	

}
