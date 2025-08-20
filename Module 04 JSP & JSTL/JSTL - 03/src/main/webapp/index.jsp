<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL FUNCTION LIBRARY</title>
</head>
<body>
	<c:set var="data" value='Hello Learning JSTL is Very Easy'/>
	<h1 style='color:blue; text-align: center;'>
		Length :: ${fn:length(data)}<br/>
		In upper case :: ${fn:toUpperCase(data) }<br/>
		In lower case :: ${fn:toLowerCase(data) }<br/>
		Substring is  :: ${fn:substring(data,6,15) }<br/>
		Does String contains JSTL  :: ${fn:contains(data,"JSTL") }<br/>
		Does String starts with Hello :: ${fn:startsWith(data,"Hello") }<br/>
		Does String ends with Easy :: ${fn:endsWith(data,"easy") }<br/>
	</h1>
	
	<hr/>
	<c:set  var='data' value='sachin,saurav,dhoni,kohli'/>
	<c:set var='names' value='${fn:split(data,",")}'/>
	<h1 style="color:green; text-align: center;">
		Result of split method is <br/>	
		<c:forEach var='name' items="${names }">
			${name }<br/>
		</c:forEach>
	</h1>
	<hr/>
	<c:set var='result' value='${fn:join(names,"-") }'/>
	<h1 style='color:red; text-align: center'>
		Result of Join method is ${result}<br/>
	</h1>
</body>
</html>