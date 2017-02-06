<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>
<%@include file="../../WEB-INF/navigation/LibrarianNav.jsp"%>

<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>

<%@page import="library.model.entity.BookTitle"%>




<html>
<head>
<title>Book Not Added</title>
</head>
<body>
	<p>
		<c:set var="errorMessageAttributeName"
			value="${ViewConstants.ERROR_MESSAGE}" />
		<c:set var="errorMessage"
			value="${requestScope[errorMessageAttributeName]}" />
		Result: ${errorMessage}
		<%@include file="../../WEB-INF/forms/BookTitleListCall.jsp"%>
		</p>
<%@include file="../../WEB-INF/navigation/Footer.jsp"%>
</body>
</html>
