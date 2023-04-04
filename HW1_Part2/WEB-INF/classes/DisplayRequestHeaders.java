import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


public class DisplayRequestHeaders extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>"); 
		out.println("<html>"); 
		out.println("<head><title>Request Headers</title></head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> The following table displays all request headers: </h1>");
		out.println("<table border=1 align=\"center\">");
		out.println("<th>Header Name</th><th>Header Value</th>");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String)headerNames.nextElement();
			Enumeration headers = request.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				out.println("<tr><td>" + headerName+"</td>");
				out.println("<td>" + (String)headers.nextElement()+"</td></tr>");
			}
		}
		
		out.println("</table></body></html>");
	}
}
	

