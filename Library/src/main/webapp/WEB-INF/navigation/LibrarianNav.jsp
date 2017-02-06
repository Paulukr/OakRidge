<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<p align="left">
	<a href="<c:out value="${pageContext.request.contextPath}${UrlConstants.C_GET_BOOK_ADD_FORM}"></c:out>"><b>Add new book</b></a>
	<a href="<c:out value="${pageContext.request.contextPath}${UrlConstants.C_GET_VOLUME_ADD_FORM}"></c:out>"><b>Add new volume</b></a>
 </p>
</body>
</html>