
package ineuron.controller; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet 1"); //to debug
		PrintWriter pw = response.getWriter();
		pw.println("<h1> Welcome to Servlets </h1>");
		RequestDispatcher reqDisp =  request.getRequestDispatcher("/Servlet2");
		reqDisp.forward(request, response);
		
	}

}
