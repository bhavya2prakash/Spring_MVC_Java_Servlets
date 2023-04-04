import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DisplayUserInput extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Display User Input Result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=1 align=\"center\">\n");
		out.println("<tr>\n");
		out.println("<th>Field Name<th>Field Value");
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String[] values = request.getParameterValues(name);
			if (name.equals("submit")) {
				continue;
			}
			out.println("<TR><TD>" + name +":");
				
			
			
				
				out.println("	 <TD>" +Arrays.toString(values));
				
			
			
		}
		out.println("</table>\n</body></html>");
	}
}