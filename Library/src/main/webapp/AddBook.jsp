<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>



<html>
<body>
<%@include file="/WEB-INF/navigation/Header.jsp"%>
<h2>Hello!</h2>
<%@include file="/WEB-INF/forms\AddBookForm.jsp"%>

<p> <a href = "NewFile.html">html file in webapps</a>

<p>Current time is: <%=  new java.util.Date() %></p>






</body>
</html>
