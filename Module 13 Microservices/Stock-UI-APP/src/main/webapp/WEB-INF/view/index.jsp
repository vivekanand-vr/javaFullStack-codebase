<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h3>Get Stock Price</h3>
	
	${msg}
	
	<form method="get" action="getTotalCost">
		<table>
			<tr>
				<td>CompanyName</td>
				<td>
					<input type='text' name='companyName'/>
				</td>
			</tr>
			
			<tr>
				<td>Quantity</td>
				<td>
					<input type='text' name='quantity'/>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type='submit' value='Get Cost'/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>