<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<html>
<body>
	<p>
		<c:set var="title_instanse_listAttributeName"
			value="${ViewConstants.TITLE_INSTANSE_LIST}" />
		<c:set var="title_instanse_list"
			value="${requestScope[title_instanse_listAttributeName]}" />
		<c:if test="${title_instanse_list != null}">
			<c:set var="outputListName" value="${ViewConstants.OUTPUT_LIST}" />
			<!-- The name attribute of the jsp:param standard action does not accept any expressions -->
			<jsp:include page="../../WEB-INF/forms/BookTitleList.jsp">
				<jsp:param name="OUTPUT_LIST" value="${title_instanse_list}" />
			</jsp:include>
		</c:if>
		<br>
	</p>
</body>
</html>