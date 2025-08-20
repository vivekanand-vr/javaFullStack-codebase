<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
<style>
  body {
    background-color: lightblue;
  }

  table {
    border-collapse: collapse;
    width: 50%;
    margin: auto;
    border: 2px solid #000;
    border-radius: 10px;
  }

  caption {
    font-size: 20px;
    font-weight: bold;
    padding: 10px;
    background-color: #f2f2f2;
    border-top: 2px solid #000;
    border-bottom: 2px solid #000;
    border-radius: 10px;
  }

  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }

  th {
    background-color: #f2f2f2;
    border-top: 2px solid #000;
    border-bottom: 2px solid #000;
  }

  h1 {
    color: red;
    text-align: center;
  }
</style>
</head>
<body>
  <br/><br/><br/>

  <c:choose>
    <c:when test="${student ne null || ! empty student}">
      <table border='1' align="center">
        <caption>STUDENT RECORD</caption>
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>AGE</th>
          <th>ADDRESS</th>
        </tr>
        <tr>
          <td>${student.sid}</td>
          <td>${student.sname}</td>
          <td>${student.sage}</td>
          <td>${student.saddress}</td>
        </tr> 
      </table>
    </c:when>
    <c:otherwise>
      <h1>No Record to display</h1>
    </c:otherwise>
  </c:choose> 
</body>
</html>
