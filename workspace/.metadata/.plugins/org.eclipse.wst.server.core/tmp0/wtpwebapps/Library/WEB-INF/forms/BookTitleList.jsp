<%@include file="../../WEB-INF/navigation/Config.jsp"%>


<html>
<body>
	<c:set var="fullName" value="${sharedId}" />
	<h1>s1: ${fullName}</h1>
	<h1>s2: ${fullName}</h1>
	<h1>
		s3:
		<c:out value="${fullName}"></c:out>
	</h1>
	<p align="center">
	PageNotFound
			<c:out value="${param.list}"/>
						<c:forEach var="title_instanse" items="${list}">
						<h3>s3: ${title_instanse.title}</h3>

</c:forEach>


			<c:set var="title_instanse_listAttributeName"
			value="${ViewConstants.TITLE_INSTANSE_LIST}" />
		<c:set var="title_instanse_list"
			value="${requestScope[title_instanse_listAttributeName]}" />
	<c:if test="${title_instanse_list != null}">

			<c:forEach var="title_instanse" items="${title_instanse_list}">
						<h3>s3: ${title_instanse.title}</h3>
<%--     			<jsp:include page="instance.jsp"> --%>
<%--         			<jsp:param name="myVar" value="${instanceVar}"/> --%>
<%--     			</jsp:include> --%>
</c:forEach>

	</c:if>


	<c:out value="${requestScope['javax.servlet.forward.request_uri']}"></c:out>
	</p>
</body>
</html>
