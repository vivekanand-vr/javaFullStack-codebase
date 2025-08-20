package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String smobile = request.getParameter("smobile");
		String semail = request.getParameter("semail");

		HttpSession session = request.getSession(false);
		session.setAttribute("semail", semail);
		session.setAttribute("smobile", smobile);

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'>Registration Details...</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			out.println("<tr><td>" + attributeName + "</td><td>" + attributeValue + "</td></tr>");

		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("Session id used is :: "+request.getRequestedSessionId());
		out.close();

	}

}
