<!DOCTYPE HTML>
<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
    <link rel="stylesheet" href="../../WEB-INF/navigation/css/foundation.css" />
</head>
<body>
<div>


	hello
	<c:set var="jitemInstanseAttributeName"
		value="${ViewConstants.JITEM_INSTANSE}" />
	<c:out value="${jitemInstanseAttributeName}" />

	<c:set var="jitemInstanse"
		value="${requestScope[jitemInstanseAttributeName]}" />
	<c:out value="${jitemInstanse}" />

	<c:if test="${jitemInstanse != null}">
		<h1 align="center">
			Item name:
			<c:out value="${jitemInstanse.name}" />
			<br>OrderNo:
			<c:out value="${jitemInstanse.orderNo}" />
<!-- 			<br><c:out value="${pageContext.request.contextPath}" />  -->
		</h1>
		<h1 align="center">
		<form action="${pageContext.request.contextPath}${UrlConstants.C_JITEM_DISPATCH}"
		 method="GET" >
			Quantity:
			<br>
			<input type="number" name= "${ViewConstants.JITEM_QUANTITY}" value="1" />
			<input type="hidden" name="${ViewConstants.JITEM_MODEL_INDEX}" value="${jitemInstanse.orderNo}">
			<br>
			<input type="submit" value="Dispatch" />
		</form>
		</h1>
	</c:if>
	<c:if test="${jitemInstanse == null}">
		<p>item not found</p>
	</c:if>
	</div>
</body>
</html>
