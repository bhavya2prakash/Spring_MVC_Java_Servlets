import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

import java.util.*;


public class GetMethods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>"); 
		out.println("<html>"); 
		out.println("<head><title>Get Methods</title></head>");
		out.println("<body>");
		out.println("<h1> The following are the get methods and thier repective return values </h1>");
		out.println("<p> Authentication Scheme : "+request.getAuthType()+ "</p>");
		out.println("<p> Context Path : "+request.getContextPath()+" </p>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		for (Cookie cookie : cookies ) {

		  out.println("<p> Cookies Name : "+cookie.getName() +" Cookies Value: "+cookie.getValue()+"</p>" );
 
		}
		}
		else{
			out.println("<p> Cookies: "+cookies+"</p>" );
			
		}
		out.println("<table>");
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
		out.println("</table>");
		out.println("<p> HTTP Method : "+request.getMethod()+" </p>"); 
		out.println("<p> Path Information : "+request.getPathInfo()+" </p>"); 
		out.println("<p> Extra Path Information : "+request.getPathTranslated()+" </p>"); 
		out.println("<p> Query String : "+request.getQueryString()+" </p>"); 
		out.println("<p> User Login : "+request.getRemoteUser()+" </p>"); 
		out.println("<p> Session Id : "+request.getRequestedSessionId()+" </p>"); 
		out.println("<p> URL from the protocol name up to the query string : "+request.getRequestURI()+" </p>"); 
		out.println("<p> URL the client used to make the request : "+request.getRequestURL()+" </p>"); 
		out.println("<p> URL that calls the servlet : "+request.getServletPath()+" </p>"); 
		
		HttpSession session = request.getSession();
		out.println("<p> Session ID : "+session.getId()+" </p>"); 
		
		Enumeration enum1 = request.getAttributeNames();  
        while (enum1.hasMoreElements()) {  
        String name = (String) enum1.nextElement();  
        String attr = (String)request.getAttribute(name);  
        out.print("<b>"+name + "</b>: ");  
        out.println(attr + "<br>");  
      } 
		out.println("<p> Character Encoding : "+request.getCharacterEncoding()+" </p>"); 
		out.println("<p> Content Length(int): "+request.getContentLength()+" </p>");
		out.println("<p> Content Length(long): "+request.getContentLengthLong()+" </p>");
		out.println("<p> Content Type: "+request.getContentType()+" </p>");
		out.println("<p> Internet Protocol (IP) address of the interface on which the request was received: "+request.getLocalAddr()+" </p>");
		out.println("<p> Host name of the Internet Protocol (IP) interface on which the request was received: "+request.getLocalName()+" </p>");
	    out.println("<p> Internet Protocol (IP) port number of the interface on which the request was received: "+request.getLocalPort()+" </p>");
		out.println("<p> Protocol: "+request.getProtocol()+" </p>");
		out.println("<p> Internet Protocol (IP) address of the client or last proxy that sent the request: "+request.getRemoteAddr()+" </p>");
		out.println("<p> Qualified name of the client or the last proxy that sent the request: "+request.getRemoteHost()+" </p>");
		out.println("<p> Internet Protocol (IP) source port of the client or last proxy that sent the request: "+request.getRemotePort()+" </p>");
		out.println("<p> Scheme of the request: "+request.getScheme()+" </p>");
		out.println("<p> Scheme of the request: "+request.getServerName()+" </p>");
		out.println("<p> Port number to which the request was sent: "+request.getServerPort()+" </p>");
		
		out.println("</body></html>");
	}
}
	

