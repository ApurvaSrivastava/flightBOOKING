package wipro.asd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fs
 */
public class Fs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String s1=request.getParameter("a");
		String s2=request.getParameter("b");
		
		if(s1.equals("james") && s2.equals("bond"))
		{
		
			pw.println("<h2>You can continuee...<h2>");
		}
		else
		{
			pw.println("<h2>Invalid user name and password...<h2>");
			
		}
		
	}

}
