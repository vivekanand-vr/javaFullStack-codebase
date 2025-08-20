<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Result Page</title>
<style>
  body {
    background-color: lightblue;
  }

  h1 {
    text-align: center;
    font-size: 24px;
    padding: 20px;
  }

  h1.success {
    color: green;
  }

  h1.failure {
    color: red;
  }
</style>
</head>
<body>
  <br/><br/><br/>

  <c:choose>
    <c:when test="${status eq 'success'}">
      <h1 class="success">RECORD DELETED SUCCESSFULLY</h1>
    </c:when>
    <c:when test="${status eq 'failure'}">
      <h1 class="failure">RECORD DELETION FAILED</h1>
    </c:when>
    <c:otherwise>
      <h1 class="success">RECORD NOT AVAILABLE FOR DELETION</h1>
    </c:otherwise>
  </c:choose>
</body>
</html>
