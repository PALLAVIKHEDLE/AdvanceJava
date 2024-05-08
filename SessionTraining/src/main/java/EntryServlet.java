

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EntryServlet
 */

@WebServlet("/@entryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parameter=request.getParameter("userName");
		HttpSession session=request.getSession();
		session.setAttribute("userName", parameter);
		response.setContentType("text/html");
		
		PrintWriter writer=response.getWriter();
		writer.append("<a href='finalServlet'>Click here </a>");
	}

	
}
