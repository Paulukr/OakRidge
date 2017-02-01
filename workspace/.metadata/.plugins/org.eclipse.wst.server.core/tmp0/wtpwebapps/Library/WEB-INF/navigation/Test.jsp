<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PageNotFound</title>
</head>
<body>
<c:set var="fullName" value="${sharedId}" />
	<h1>s1: ${fullName}</h1>
	<h1>s2: ${fullName}</h1>
	<h1>
		s3:
		<c:out value="${fullName}"></c:out>
	</h1>
	<p>
		<c:out value="tag"></c:out>
	</p>
	<p>
		<c:out value="${ViewConstants.TITLE_NAME}"></c:out>
	</p>
	<p>
		<c:out value="tag"></c:out>
	</p>
	<p>${ViewConstants.TITLE_NAME}</p>
	<p>
		<c:out value="tag"></c:out>
	</p>
	<p>${ViewConstants.getString()}</p>
	<p>
		<c:out value="tag"></c:out>
	</p>
</body>
</html>