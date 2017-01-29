<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 07.07.2016
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#d3d3d3">
<br><br><br>
<table border="1" width="400" heigth="250" align="center">
    <h2 align="center">Currency info table</h2>
    <tr>
        <td align="center"><b>Currency pair</b></td>
        <td align="center"><b>Rate</b></td>
        <td align="center"><b>Ask</b></td>
        <td align="center"><b>Bid</b></td>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td style="text-indent: 10px"><c:out value="${s.name}"/> </td>
            <td style="text-indent: 10px"><c:out value="${s.rate}"/> </td>
            <td style="text-indent: 10px"><c:out value="${s.ask}"/></td>
            <td style="text-indent: 10px"><c:out value="${s.bid}"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<p align="center"><a href="index.jsp"><b>Return to main</b></a> </p>
</body>
</html>
