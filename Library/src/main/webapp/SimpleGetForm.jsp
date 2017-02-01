<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@include file="../../WEB-INF/navigation/Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> ${UrlConstants.BOOK_ADD} </p>
	<form action="${UrlConstants.BOOK_SEARCH}" method="GET">
			Book Title: <input type="text" name="${ViewConstants.TITLE_NAME}" size="40"> <br />
<!-- 		First Name: <input type="text" name="first_name"> <br /> Last -->
<!-- 		Name: <input type="text" name="last_name" />  -->
		<input type="submit"
			value="Submit" />
	</form>
</body>
</html>
