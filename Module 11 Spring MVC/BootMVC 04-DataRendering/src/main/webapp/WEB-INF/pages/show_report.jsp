	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Output Page</title>
	</head>
	<body>
		<center>
			<%-- 
			
			Passsing simple objects to model and rendering it 
			---------------------------------------------------
			<h1 style='color: red; text-align: center;'>Displaying Simple
				values</h1>
			<h1>name is :: ${name}</h1>
			<h1>age is :: ${age}</h1>
			<h1>address is :: ${address}</h1>
			<hr>
			
			Using the array object passed by controller
			--------------------------------------------
			<h1 style='color: red; text-align: center;'>Displaying Array values</h1>
			<b>CountryNames</b><br/>
			<c:forEach var="country" items="${countryNames}">
				${country}<br/>
			</c:forEach>
			<hr/>
			
			
			Using the list object passed by controller
			--------------------------------------------
			<h1 style='color: red; text-align: center;'>Displaying List
				values</h1>
			<b>SubjectNames</b><br/>
			<c:forEach var="subject" items="${subjectList}">
				${subject}<br/>
			</c:forEach>
			<hr/>
			
			
			Using the set object passed by controller
			--------------------------------------------
			<h1 style='color: red; text-align: center;'>Displaying Set values</h1>
			<b>MobileNumbers</b><br/>
			<c:forEach var="mobile" items="${mobileSet}">
				${mobile}<br/>
			</c:forEach>
			<hr/>
			
			Using the array object passed by controller
			--------------------------------------------
			<h1 style='color: red; text-align: center;'>Displaying Map values</h1>
			<b>IDInfo</b><br/>
			<c:forEach var="id" items="${idsMap}">
				${id.key} ======> ${id.value }<br/>
			</c:forEach> --%>
	
			<h1 style='color: red;'>Displaying List of DTO</h1>
			<table border='1'>
				<tr>
					<th>ENO</th>
					<th>ENAME</th>
					<th>EDESG</th>
					<th>SALARY</th>
				</tr>
	
				<c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp.eno}</td>
						<td>${emp.ename}</td>
						<td>${emp.edesg}</td>
						<td>${emp.salary}</td>
					</tr>
	
				</c:forEach>
	
			</table>
			<hr/>
			
			
			<h1 style='color:red; text-align: center;'>
				Reading Model Object Data
			</h1>
			<b>EMPNO     IS :: ${employee.eno}</b><br/>
			<b>EMPNAME   IS :: ${employee.ename}</b><br/>
			<b>EMPDESG   IS :: ${employee.edesg}</b><br/>
			<b>EMPSALARY IS :: ${employee.salary}</b>
	
		</center>
	</body>
	</html>
