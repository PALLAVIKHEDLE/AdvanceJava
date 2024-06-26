

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ViewUserData
 */
public class ViewUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			ServletContext servletContext=config.getServletContext();
//			ServletContext servletContext=getServletContext();//This method will come from the generic servlet class
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(servletContext.getInitParameter("connectionURL"),servletContext.getInitParameter("userName"),servletContext.getInitParameter("password"));
			System.out.println("Connection Established ");	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Statement statement = connection.createStatement();	
			ResultSet resultSet=statement.executeQuery("select * from user");
			while(resultSet.next()) {
//				System.out.println("User's FirstName is "+resultSet.getString("firstName").trim());
				System.out.println("User's LastName is "+resultSet.getString(1).trim());
				System.out.println("User's LastName is "+resultSet.getString(2).trim());
				System.out.println("UserName  is "+resultSet.getString(3).trim());
				System.out.println("Password is "+resultSet.getString(4).trim());
				System.out.println("---------------------------------------------");					
			}
			 resultSet.close();
			 statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

