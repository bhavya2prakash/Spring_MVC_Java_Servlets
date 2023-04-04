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
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form Submission 3.2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Form Submitted Data</h1>");
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> parameter : map.entrySet()) {
			String name = parameter.getKey();
			String[] values = parameter.getValue();
			if (name.equals("submit")) {
				continue;
			}
			out.println("<p>" + name + ": ");
			for (String value : values) {
				out.println(value + " ");
			}
			out.println("</p>");
		}
		out.println("</body>");
		out.println("</html>");	
			
	}
}