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
		s1: ${errorMessage}
	<p>
			<c:set var="title_instanse_listAttributeName"
			value="${ViewConstants.TITLE_INSTANSE_LIST}" />
		<c:set var="title_instanse_list"
			value="${requestScope[title_instanse_listAttributeName]}" />
	<c:if test="${title_instanse_list != null}">

			<c:forEach var="title_instanse" items="${title_instanse_list}">
						<h3>s3: ${title_instanse.title}</h3>

</c:forEach>
    			<jsp:include page="../../WEB-INF/forms/BookTitleList.jsp">
        			<jsp:param name="list" value="${title_instanse_list}"/>
    			</jsp:include>

	</c:if>


	<p> <a href="NewFile.html">html file in webapps</a>
	<p>Current time is: <%=new java.util.Date()%></p>
</body>
</html>
