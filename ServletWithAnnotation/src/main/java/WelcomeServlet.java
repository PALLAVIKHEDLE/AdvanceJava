import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/annotation")

public class WelcomeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    response.setContentType("text/html"); 
         
	        PrintWriter writer = response.getWriter(); 
	          
	        writer.append("<html>"); 
	        writer.append("<body>"); 
	        writer.append("<h1>Welcome to Servlet with annotation</h1>"); 
	        writer.append("</html>"); 
	        writer.append("</body>"); 
	      
	}
}
