<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<c:set scope="request" var="name" value="sachin" />
	<h1 style='color: red; text-align: center;'>
		THE USERNAME IS ::
		<c:out value="${name}" />
	</h1>
	<br />

	<c:set var='x' value='10' />
	<c:set var='y' value='20' />
	<c:set var='z' value='${x+y}' scope="application" />

	<h1 style='color: blue; text-align: center;'>
		The result is ::
		<c:out value='${z}' />
	</h1>
	<br />

	<h1 style='color: green; text-align: center;'>
		The data from query string is ::
		<c:out value='${param.username}' default="iNeuron" />
	</h1>
	
</body>
</html>

