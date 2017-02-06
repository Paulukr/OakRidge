<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>
<%@include file="../../WEB-INF/navigation/LibrarianNav.jsp"%>

<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>

<html>
<body>
	<h2>New Book Added</h2>
	<p>
		<c:set var="errorMessageAttributeName"
			value="${ViewConstants.ERROR_MESSAGE}" />
		<c:set var="errorMessage"
			value="${requestScope[errorMessageAttributeName]}" />
		Result: ${errorMessage}
		<%@include file="../../WEB-INF/forms/BookTitleListCall.jsp"%>
	</p>
</body>
</html>
