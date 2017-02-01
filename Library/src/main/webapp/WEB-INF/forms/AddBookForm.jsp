<%@include file="../../WEB-INF/navigation/Config.jsp"%>

<%@page import="library.controller.UrlConstants"%>
<%@page import="library.controller.ViewConstants"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${requestScope} --%>

<c:set var="titleListAttributeName" value="${ViewConstants.TITLE_TYPES_LIST}"/>
<c:set var="titleList" value="${requestScope[titleListAttributeName]}"/>
		
	<h1>IL: ${titleList[0]}</h1>
	
	
	
	<h2 align="center">Currency info table</h2>
	<table border="1" width="400" align="center">
		<thead>
			<tr>
				<th align="center"><b>Currency pair</b></th>
				<th align="center"><b>Rate</b></th>
				<th align="center"><b>Ask</b></th>
				<th align="center"><b>Bid</b></th>
			</tr>
		</thead>
		<c:forEach items="${titleList}" var="s">
			<tr>
				<td style="text-indent: 10px"><c:out value="${s}" /></td>
<%-- 				<td style="text-indent: 10px"><c:out value="${s.rate}" /></td> --%>
<%-- 				<td style="text-indent: 10px"><c:out value="${s.ask}" /></td> --%>
<%-- 				<td style="text-indent: 10px"><c:out value="${s.bid}" /></td> --%>
			</tr>
		</c:forEach>
	</table>





	<form action="${pageContext.request.contextPath}${UrlConstants.C_BOOK_ADD}" method="POST">
		Book Title: <input type="text" name="${ViewConstants.TITLE_NAME}" size="40"> <br />
		Book Category: <select name="${ViewConstants.TITLE_TYPE}">
				<c:forEach items="${titleList}" var="s">
							<option value="${s}">${s}</option>
						</c:forEach>

			</select>
		 <br /> 
		Year Published: <input type="text" name="${ViewConstants.TITLE_YEAR}"><br /> 
		Author: <input type="text" name="${ViewConstants.TITLE_AUTHOR}"> <br />
		 <input type="submit" value="Submit" />
	</form>
	
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