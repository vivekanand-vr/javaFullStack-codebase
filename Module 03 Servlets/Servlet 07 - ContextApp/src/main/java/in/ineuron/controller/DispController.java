package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("DispControllerServlet.class file is loading...");
	}
	public DispController() {
		System.out.println("DispControllerServlet object is instantiated...");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("DispControllerServlet Object is initialised with config object data....");
	}


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green;'>CONTEXT PARAMTER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>ContextParameter Name</th><th>ContextParameter Value</th></tr>");

		ServletContext context = getServletContext();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramterName = (String) parameterNames.nextElement();
			String paramterValue = context.getInitParameter(paramterName);
			out.println("<tr>");
			out.println("<td>" + paramterName + "</td>");
			out.println("<td>" + paramterValue + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}

}
