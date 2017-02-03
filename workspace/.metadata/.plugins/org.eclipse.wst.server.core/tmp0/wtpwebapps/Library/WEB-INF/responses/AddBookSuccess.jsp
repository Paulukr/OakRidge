<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>

<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>




<html>
<body>
<h2>New Book Added</h2>
	<c:set var="bookTitleInstanceAttributeName"
		value="${ViewConstants.TITLE_INSTANSE}" />
	<c:set var="bookTitleInstance" value="${requestScope[bookTitleInstanceAttributeName]}" />
	<h1>s1: ${bookTitleInstance.title}</h1>
</body>
</html>
