package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>SECONDPAGE</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println(
				"<h1 style='color: red;'>iNeuron Intelligence Private limited</h1>");
		out.println("<form method='post' action='./second'>");
		out.println("<input type='hidden' name='sname' value='" + sname + "'/>");
		out.println("<input type='hidden' name='sage' value='" + sage + "'/>");
		out.println("<table>");
		out.println("<tr><td>SGENDER</td><td><input type='text' name='sgen'/></td></tr>");
		out.println("<tr><td>SADDR</td><td><input type='text' name='saddr'/></td></tr>");
		out.println("<tr><td></td><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
