import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


public class FormSubmission extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException {
		handleSubmission(request,response);

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		handleSubmission(request,response);
		
	}
	public void handleSubmission (HttpServletRequest request, HttpServletResponse response)
		throws IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String picture = request.getParameter("picture");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String[] hobby = request.getParameterValues("hobby");
		String address = request.getParameter("address");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form Submission</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Form Submitted Data</h1>");
		out.println("<p>Email: " + email + "</p>");
		out.println("<p>Password: " + password + "</p>");
		out.println("<p>Confirm Password: " + confirmPassword + "</p>");
		out.println("<p>Picture: " + picture + "</p>");
		out.println("<p>Gender: " + gender + "</p>");
		out.println("<p>Country: " + country + "</p>");
		out.println("<p>Hobby: ");
		for (String h : hobby) {
			out.println(h + " ");
		}
		out.println("</p>");
		out.println("<p>Address: " + address + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}