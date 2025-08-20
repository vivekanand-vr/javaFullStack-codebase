package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sgen = request.getParameter("sgen");
		String saddr = request.getParameter("saddr");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>THIRDPAGE</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'>iNeuron Intelligence Private limited</h1>");
		out.println("<form method='post' action='./third'>");
		out.println("<input type='hidden' name='sname' value='" + sname + "'/>");
		out.println("<input type='hidden' name='sage' value='" + sage + "'/>");
		out.println("<input type='hidden' name='sgen' value='" + sgen + "'/>");
		out.println("<input type='hidden' name='saddr' value='" + saddr + "'/>");
		out.println("<table>");
		out.println("<tr><td>MARKS</td><td><input type='text' name='smarks'/></td></tr>");
		out.println("<tr><td>BRANCH</td><td><input type='text' name='sbranch'/></td></tr>");
		out.println("<tr><td></td><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
