<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<%@include file="WEB-INF/navigation/LibrarianNav.jsp"%>
<%@include file="Clock.jsp"%>
<%@include file="NewFile.html"%>
<%@include file="SimpleGetForm.html"%>
<%@include file="SimpleGetForm.html"%>
<body>
<h2>Hello World!</h2>
<h2>Привіт!</h2>

<p> <a href = "NewFile.html">html file in webapps</a>

<%-- <% --%>
// String path = "E:\\Android\\eclipse\\new.txt";
// String text = "";

// try {
// 	text = new java.util.Scanner(new java.io.File("E:\\Android\\eclipse\\new.txt")).useDelimiter("\\Z").next();
// } catch (java.io.FileNotFoundException e2) {
// 	e2.printStackTrace();
// }
// if (text.length() == 0) {
// 	text = "There was no text";
// }
<%--  %> --%>

<%@include file="SimpleGetForm.html"%>


<%int[] item = new int[20]; %>
<p>The square root of 5 is <%= Math.sqrt(5) %></p>
<h5><%= item[10] %></h5>
<p>Current time is: <%=  new java.util.Date() %></p>






</body>
</html>
