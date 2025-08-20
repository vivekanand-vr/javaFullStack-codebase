<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
   <%
   	int[] arr = {};
   java.util.ArrayList<Integer> al =  new java.util.ArrayList<Integer>();
   	
   %>
	${empty sachin }<br/>
	${empty "sachin"}<br/>
	${empty null }<br/>
	${empty arr }<br/>
	${empty al }
	<hr/>
	${10 + null }<br/>
	${empty null }<br/>
	${!null}
</body>
</html>

