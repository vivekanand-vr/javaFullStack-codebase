package ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");
		
		if(userName.contentEquals("vivek") && userPassword.contentEquals("vicky"))
		{
			RequestDispatcher reqDisp = request.getRequestDispatcher("/sucess.jsp");
			reqDisp.forward(request, response);
		}
		
		else {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/error.jsp");
			reqDisp.forward(request, response);
		}
		
		
	}

}
