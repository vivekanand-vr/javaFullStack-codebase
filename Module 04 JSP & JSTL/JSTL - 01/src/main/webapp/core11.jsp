<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

	<%--Enhanced for loop to iterate collection and array --%>
	<table border='1'>
		<tr>
			<th>KEY</th>
			<th>VALUE</th>
		</tr>
		<c:forEach var="p" items="${param}">
			<tr>
				<th>${p.key}</th>
				<td>${p.value}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />

</body>
</html>

