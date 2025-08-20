<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style='color:red; text-align: center;'>EMPLOYEE DATA</h1>
		<table border='1'>
			<tr>
				<th>ENO</th>
				<td>${employee.eno}</td>
			</tr>
			<tr>
				<th>ENAME</th>
				<td>${employee.ename}</td>
			</tr>
			<tr>
				<th>EDESG</th>
				<td>${employee.edesg}</td>
			</tr>
			<tr>
				<th>SALARY</th>
				<td>${employee.salary}</td>
			</tr>
		</table>
	</center>
</body>
</html>