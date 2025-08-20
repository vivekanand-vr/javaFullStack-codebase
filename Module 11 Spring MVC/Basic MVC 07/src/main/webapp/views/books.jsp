<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Books Details you stored as : </h2>

<table>
<tr>
<td>Book Name :</td>
<td>${books.bname}</td>
</tr>


<tr>
<td>Author Name :</td>
<td>${books.authorName}</td>
</tr>


<tr>
<td>Book price : </td>
<td>${books.bprice}</td>
</tr>


</table>

<a href="loadingform"> RE LOAD FORM</a>
</body>
</html>