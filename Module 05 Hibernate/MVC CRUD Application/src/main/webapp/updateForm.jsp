<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
<style>
  body {
    background-color: lightblue;
  }

  form {
    margin: 0 auto;
    width: 50%;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
  }

  th, td {
    padding: 10px;
    text-align: left;
  }

  input[type="text"], input[type="submit"] {
    padding: 8px 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 14px;
    margin: 5px 0;
  }

  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }

  h1 {
    color: red;
    text-align: center;
  }
</style>
</head>
<body>
  <br/><br/>

  <c:choose>
    <c:when test="${student ne null || !empty student}">
      <form method="get" action="./controller/updateRecord">
        <table>
          <tr>
            <th>Student ID</th>
            <td><input type="text" readonly="readonly" name='sid' value='${student.sid }'/></td>
          </tr>
          <tr>
            <th>Student Name</th>
            <td><input type="text" name='sname' value='${student.sname }'/></td>
          </tr>
          <tr>
            <th>Student Age</th>
            <td><input type="text" name='sage' value='${student.sage }'/></td>
          </tr>
          <tr>
            <th>Student Address</th>
            <td><input type="text" name='saddr' value='${student.saddress }'/></td>
          </tr>
          <tr>
            <th></th>
            <td><input type="submit" value='Update'/></td>
          </tr>
        </table>
      </form>
    </c:when>
    <c:otherwise>
      <h1>NO RECORD TO DISPLAY</h1>
    </c:otherwise>
  </c:choose>
</body>
</html>
