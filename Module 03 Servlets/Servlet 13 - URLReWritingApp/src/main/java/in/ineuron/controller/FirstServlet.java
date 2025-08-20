package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accNo = request.getParameter("accNo");
		String accName = request.getParameter("accName");

		HttpSession session = request.getSession();
		session.setAttribute("accNo", accNo);
		session.setAttribute("accName", accName);

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Deposit form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Deposit form...</h1>");
		out.println("<form method='post'action='" + response.encodeURL("./second") + "'>");
		out.println("<table>");
		out.println("<tr><th>Account Type</th><td><input type='text' name='accType'/></td></tr>");
		out.println("<tr><th>Account Branch</th><td><input type='text' name='accBranch'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
