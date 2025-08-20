package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitializationParamterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<center><h1>Initialziation Parameters</h1></center><hr/>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		Enumeration<String> parameterNames = getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			String value = getInitParameter(parameterName);
			out.println("<tr><td>" + parameterName + "</td><td>" + value + "</td></tr>");
		}
		out.println("</table>");

		out.close();

	}

}
