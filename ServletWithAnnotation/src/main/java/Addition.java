import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addition")
public class Addition extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number1=req.getParameter("number1");
		String number2=req.getParameter("number2");
		int sum=Integer.parseInt(number1)+Integer.parseInt(number2);
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter(); 
		writer.append("Addition of two number is:" +sum);
		writer.close();
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number1=req.getParameter("number1");
		String number2=req.getParameter("number2");
		int sum=Integer.parseInt(number1)+Integer.parseInt(number2);
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter(); 
		writer.append("Addition of two number is:" +sum);
		writer.close();
		
		
	}
}
