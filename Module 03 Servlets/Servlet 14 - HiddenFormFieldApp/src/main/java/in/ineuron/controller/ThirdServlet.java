package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sgen = request.getParameter("sgen");
		String saddr = request.getParameter("saddr");
		String smarks = request.getParameter("smarks");
		String sbranch = request.getParameter("sbranch");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>THIRDPAGE</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'>iNeuron Intelligence Private limited</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><td>" + sname + "</td></tr>");
		out.println("<tr><th>AGE</th><td>" + sage + "</td></tr>");
		out.println("<tr><th>GEN</th><td>" + sgen + "</td></tr>");
		out.println("<tr><th>SADDR</th><td>" + saddr + "</td></tr>");
		out.println("<tr><th>MARKS</th><td>" + smarks + "</td></tr>");
		out.println("<tr><th>BRANCH</th><td>" + sbranch + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
