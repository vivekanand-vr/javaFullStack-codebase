<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<%-- Traditional for loop --%>
	<table border='1' bgcolor='cyan'>
		<c:forEach var="i" begin="1" end="10" step="1">
			<tr>
				<td>2 * ${i}</td>
				<td>${2*i }</td>
			</tr>
		</c:forEach>
	</table>

	<%
	String names[] = { "sachin", "kohli", "dhoni", "Gill" };
	request.setAttribute("names", names);
	List<String> stringList = new ArrayList<String>();
	stringList.add("MI");
	stringList.add("RCB");
	stringList.add("CSK");
	stringList.add("GT");
	request.setAttribute("stringList", stringList);
	%>
<br/><br/>

<%--Enhanced for loop to iterate collection and array --%>
<c:forEach var="name" items="${names}">
	<h1>Name is :: ${name}</h1>
</c:forEach>
<br/><br/>

<%--Enhanced for loop to iterate collection and array --%>
<c:forEach var="list" items="${stringList}">
	<h1>Name is :: ${list}</h1>
</c:forEach>

</body>
</html>

