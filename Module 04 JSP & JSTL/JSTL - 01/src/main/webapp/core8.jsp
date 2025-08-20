<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<c:set var="msg" value="welcome" scope="request"/>
	<c:if test="${!empty param.userName }">
		<h1 style='color:green; text-align: center;'>
			<c:out value="${msg }"/>
			<c:out value="${param.userName }"/>
		</h1>
	</c:if>
</body>
</html>

