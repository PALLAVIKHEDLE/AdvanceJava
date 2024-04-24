

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
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
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
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		
		try {
			Statement statement=connection.createStatement();
			String queryString="update user set password='"+password+"' where userName='"+userName+"'";
			System.out.println(queryString);
			int executeUpdate=statement.executeUpdate(queryString);
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			System.out.println(executeUpdate);
			if(executeUpdate > 0) writer.append("User Details updated Successfully!");
			else writer.append("Error updating the User details.");
		
			statement.close();
			writer.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}