<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//read form data
String username = request.getParameter("uname");
String password = request.getParameter("password");

//No inputs
if (username.equals("") || password.equals("") || username.length() == 0 || password.length() == 0) {
	out.println("provide credentials");
	return;
}

//Provide logic for authentication
if (username.equalsIgnoreCase("sachin") && password.equals("tendulkar"))
	out.println("valid credentials");
else
	out.println("invalid credentials");
%>
