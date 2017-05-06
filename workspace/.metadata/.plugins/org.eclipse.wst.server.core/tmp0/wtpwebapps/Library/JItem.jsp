<!DOCTYPE HTML>
<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<body>
	hello
	<c:set var="jitemInstanseAttributeName"
		value="${ViewConstants.JITEM_INSTANSE}" />
	<c:out value="${jitemInstanseAttributeName}" />

	<c:set var="jitemInstanse"
		value="${requestScope[jitemInstanseAttributeName]}" />
	<c:out value="${jitemInstanse}" />

	<c:if test="${jitemInstanse != null}">
		<p>
			item name:
			<c:out value="${jitemInstanse.name}" />
			<c:out value="${pageContext.request.contextPath}" />
		</p>

		<form action="${pageContext.request.contextPath}${UrlConstants.C_JITEM_DISPATCH}"
		 method="GET">
			Quantity: <input type="number" name="quantuty" value="1" /> <input
				type="submit" value="Submit" />
		</form>

	</c:if>
	<c:if test="${jitemInstanse == null}">
		<p>item not found</p>
	</c:if>
</body>
</html>
