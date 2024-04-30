

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init loaded for login servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entered into servlet");
		Connection connection=null;

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root@123");
			System.out.println(connection);
			Statement statement=connection.createStatement();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			ResultSet resultSet=statement.executeQuery("select * from user where username='"+userName+"' and password='"+password+"'");
	
			
			if(!resultSet.next()) {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("loginPage.html");
				requestDispatcher.include(request, response);//in case of failure we have to fshow user same login page
			}
			while(resultSet.next()) {
				if(resultSet.getString(1)!=null) {
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("successServlet");
					requestDispatcher.forward(request, response);//in case of success we have to forward our request to success servlet
					
				}
				
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
