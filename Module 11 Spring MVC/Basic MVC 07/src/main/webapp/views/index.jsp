<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to my Book store</h1>
<form action="save" method="POST">
<table>
<tr>
<td> Book Name: </td>
<td> <input type="text" name="bname"/></td>
</tr>

<tr>
<td> Author Name: </td>
<td> <input type="text" name="authorName"/></td>
</tr>

<tr>
<td> Book Price: </td>
<td> <input type="number" name="bprice"/></td>
</tr>

<tr>

<td> <input type="submit" value="submit"/></td>
</tr>

</table>

</form>
</body>
</html>