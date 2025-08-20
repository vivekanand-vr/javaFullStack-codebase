package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Implementation classes of tomcat server is ::");
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		System.out.println("Implementation class of config is :: " + config.getClass().getName());
		System.out.println("Implementation class of context is :: " + context.getClass().getName());
		System.out.println("Implementation class of request is :: " + request.getClass().getName());
		System.out.println("Implementation class of response is :: " + response.getClass().getName());

	}

}
