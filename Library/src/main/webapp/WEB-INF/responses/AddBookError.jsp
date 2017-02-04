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
	<p>
		<c:set var="title_instanse_listAttributeName"
			value="${ViewConstants.TITLE_INSTANSE_LIST}" />
		<c:set var="title_instanse_list"
			value="${requestScope[title_instanse_listAttributeName]}" />
		<c:if test="${title_instanse_list != null}">
			<c:set var="outputListName" value="${ViewConstants.OUTPUT_LIST}" />
<!-- The name attribute of the jsp:param standard action does not accept any expressions -->
			<jsp:include page="../../WEB-INF/forms/BookTitleList.jsp">
				<jsp:param name="OUTPUT_LIST" value="${title_instanse_list}" />
			</jsp:include>
		</c:if>
				<br>
		</p>

	<p>
					<br>
		<a href="NewFile.html">html file in webapps</a>
		</p>
	<p>
		Current time is:
		<%=new java.util.Date()%></p>
</body>
</html>
