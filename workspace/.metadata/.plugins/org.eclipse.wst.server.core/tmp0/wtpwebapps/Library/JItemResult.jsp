<!DOCTYPE HTML>
<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<body>
	hello
	<c:set var="jitemDispatchResultAttributeName"
		value="${ViewConstants.JITEM_DISPATCH_RESULT}" />
	<c:out value="${jitemDispatchResultAttributeName}" />

	<c:set var="jitemDispatchResult"
		value="${requestScope[jitemDispatchResultAttributeName]}" />
	<c:out value="${jitemInstanse}" />

	<c:if test="${jitemDispatchResult > 0}">
		<p>
			Dispatch recorded
			<br>
			Dispatch No:
			<c:out value="${jitemDispatchResult}" />
		</p>
	</c:if>
	<c:if test="${jitemDispatchResult < 1}">
		<p>Dispatch NOT recorded</p>
	</c:if>
</body>
</html>
