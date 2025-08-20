<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

	<c:forTokens items="sachin$dhoni$kohli$Gill" delims="$" var="name">
		<h1>Names are :: ${name}</h1>
	</c:forTokens>

</body>
</html>

