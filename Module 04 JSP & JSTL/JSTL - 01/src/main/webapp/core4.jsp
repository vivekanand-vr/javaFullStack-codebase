<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<h1 style='color:blue; text-align: center;'>THE USERNAME IS :: ${param.userName }</h1>
	
	<c:catch var="e">
		<jsp:scriptlet>
			Integer userAge = Integer.parseInt(request.getParameter("userAge"));
		</jsp:scriptlet>
		<h1 style='color:blue; text-align: center;'>THE USERAGE IS :: ${param.userAge }</h1>
	</c:catch>
	
	<c:if test="${!empty e }">
		<br/><h1 style='color:red; text-align: center;'>The exception raise is :: ${e}</h1>
	</c:if>
	
	<h1 style='color:blue; text-align: center;'>
		THE USERHEIGHT IS :: ${param.userHeight }
	</h1>
	
</body>
</html>

