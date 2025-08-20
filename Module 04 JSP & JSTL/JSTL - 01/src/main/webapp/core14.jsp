<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

	<h1>Welcome to iNeuron...</h1>
	<c:import url="core15.jsp">
		<c:param name="sub1" value='java' />
		<c:param name="sub2" value='Advancedjava' />
		<c:param name="sub3" value='Framework' />
	</c:import>
</body>
</html>

