package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String squal = request.getParameter("squal");
		String sdesg = request.getParameter("sdesg");

		HttpSession session = request.getSession(false);
		session.setAttribute("squal", squal);
		session.setAttribute("sdesg", sdesg);

		RequestDispatcher rd = request.getRequestDispatcher("./form3.html");
		rd.forward(request, response);

	}

}
