<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page of Insertion</title>
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
  <br/><br/>

  <c:choose>
    <c:when test="${status eq 'success'}">
      <h1 class="success">RECORD INSERTED SUCCESSFULLY</h1>
    </c:when>
    <c:otherwise>
      <h1 class="failure">RECORD INSERTION FAILED</h1>
    </c:otherwise>
  </c:choose>
</body>
</html>
