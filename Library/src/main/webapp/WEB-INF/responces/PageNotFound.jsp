<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PageNotFound</title>
</head>
<body>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<body>
<%-- <cut value= "${shared}"/> --%>
<%-- <cut value= "${requestScope.shared}"/> --%>
<%-- <cut value= "${requestScope.request.shared}"/> --%>

    <c:set var="fullName" value="${shared}" />
    <h1>${fullName}</h1>



<%
 String shared = (String)request.getAttribute("sharedId");
%>
<%= shared %>
<p align="center">PageNotFound</p>
<p> <c:out value=""></c:out> </p>
</body>
</html>