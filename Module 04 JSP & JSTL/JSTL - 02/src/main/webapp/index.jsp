<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix='sql'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP PAGES</title>
</head>
<body>
	<sql:setDataSource url="jdbc:mysql:///octbatch" user="root"
		password="root123" driver="com.mysql.cj.jdbc.Driver" var="dataSource" />

	<sql:query var="result" dataSource="${dataSource}">
			SELECT * from employee
	</sql:query>
<h1 style='color:green; text-align: center'>EMPLOYEE DATA OF INEURON</h1>
	<table border='1' align="center">
		<tr>
			<th>EID</th>
			<th>ENAME</th>
			<th>EADDR</th>
			<th>ESAL</th>
		</tr>
		<c:forEach var='row' items='${result.rows}'>
			<tr>
				<td>${row.eid}</td>
				<td>${row.ename}</td>
				<td>${row.eaddr}</td>
				<td>${row.esal}</td>
			</tr>
		</c:forEach>
	</table>

	<sql:update dataSource="${dataSource}" var="count">
		insert into employee(`ename`,`eaddr`,`esal`) values ('hyder','RCB',21000)
	</sql:update>
	<h1 style='color: red; text-align: center;'>The no of rows updated
		are :: ${count}</h1>


	<sql:update dataSource="${dataSource}" var="count">
		insert into employee(`ename`,`eaddr`,`esal`) values (?,?,?)
		<sql:param value='nitin' />
		<sql:param value='RCB' />
		<sql:param value='10000' />
	</sql:update>
	<h1 style='color: red; text-align: center;'>The no of rows updated
		are :: ${count}</h1>

	<sql:transaction dataSource="${dataSource}">
		<sql:update>
				update employee set esal = esal + 10000 where ename='hyder'
		</sql:update>
		
		<sql:update>
				update employee set esal = esal + 5000 where ename='nitin'
		</sql:update>
	</sql:transaction>
	

</body>
</html>