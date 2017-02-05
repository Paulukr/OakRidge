<%@include file="../../WEB-INF/navigation/Config.jsp"%>

<%@page import="library.controller.UrlConstants"%>
<%@page import="library.controller.ViewConstants"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Type book info here</title>
</head>
<body>
	<c:set var="titleListAttributeName"
		value="${ViewConstants.TITLE_TYPES_LIST}" />
	<c:set var="titleList" value="${requestScope[titleListAttributeName]}" />

	<form
		action="${pageContext.request.contextPath}${UrlConstants.C_BOOK_ADD}"
		method="POST">
		Book Title: <input type="text" name="${ViewConstants.TITLE_NAME}" value="Sherlock"
			size="40"> <br />
		Book Category: <select
			name="${ViewConstants.TITLE_TYPE_NO}">
			<c:forEach items="${titleList}" var="s" varStatus="loop">
				<option value="${loop.index + 1}">${s}</option>
			</c:forEach>
		</select> <br />
		Year Published: <input type="text"
			name="${ViewConstants.TITLE_YEAR}" value="2000"><br />
		Author: <input
			type="text" name="${ViewConstants.TITLE_AUTHOR}" value="Man"> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>