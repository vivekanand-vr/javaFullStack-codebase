<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<center>
		<h1 style="color: red; text-align: center;">Employee Registration
			Page</h1>
		<form method='POST'>
			<table>
				<tr>
					<th>ENO</th>
					<td><input type='text' name='eno'></td>
				</tr>
				<tr>
					<th>ENAME</th>
					<td><input type='text' name='ename'></td>
				</tr>
				<tr>
					<th>EDESG</th>
					<td><input type='text' name='edesg'></td>
				</tr>
				<tr>
					<th>SALARY</th>
					<td><input type='text' name='salary'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='submit' value='register'></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>
