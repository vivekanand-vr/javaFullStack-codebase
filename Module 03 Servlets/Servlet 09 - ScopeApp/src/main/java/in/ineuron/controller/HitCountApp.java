package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hit")
public class HitCountApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("hitcount");
		if (count == null)
			count = 1;
		else
			count++;

		context.setAttribute("hitcount", count);
		out.println("<h1>Hit count of the application is :: " + count + "</h1>");

		out.close();

	}

}
