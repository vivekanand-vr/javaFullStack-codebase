<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

	<%--Defining the URL to send the request --%>
	<c:url value="http://www.google.com" var="googleURl" scope="request" />

	<%-- perform sendRedirection --%>
	<c:redirect url="${googleURl}" />
</body>
</html>

