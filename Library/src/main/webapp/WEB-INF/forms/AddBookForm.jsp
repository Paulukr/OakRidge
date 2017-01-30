<%@include file="../../WEB-INF/navigation/Config.jsp"%>

<%@page import="library.controller.UrlConstants"%>
<%@page import="library.controller.ViewConstants"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<form action="map/librarian/book/add" method="POST">
		Book Title: <input type="text" name="ds" size="40"> <br />
		Book Category: <select name="BookType">
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="fiat">Fiat</option>
			<option value="audi">Audi</option>
		</select> <br /> Year Published: <input type="text" name="BookTitle">
		<br /> Author: <input type="text" name="BookTitle"> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>