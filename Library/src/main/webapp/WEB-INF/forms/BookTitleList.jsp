<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<html>
<body>

	<c:set var="outputListName" value="${ViewConstants.OUTPUT_LIST}" />
	<c:set var="localListName" value="${param.outputListName}" />
	<c:out value="localListName"></c:out>
	<c:set var="title_instanse_listAttributeName"
		value="${ViewConstants.TITLE_INSTANSE_LIST}" />
	<c:set var="title_instanse_list"
		value="${requestScope[title_instanse_listAttributeName]}" />
		<h3 align="center">Following titles available</h3>

	<c:if test="${title_instanse_list != null}">
		<!-- 		<table border="1" width="400" height="250" align="center"> -->
		<table border="1" align="left">
			<tr>
				<th align="center"><b>No</b></th>
				<th align="center"><b>Title</b></th>
				<th align="center"><b>Action</b></th>
			</tr>
			<c:forEach var="title_instanse" items="${title_instanse_list}"
				varStatus="loop">
				<td style="text-indent: 10px"><c:out value="${loop.index + 1}" /></td>
				<td style="text-indent: 10px"><c:out
						value="${title_instanse.title}" /></td>
				<td style="text-indent: 10px">
					 <a href="NewFile.html?a=${loop.index + 1}">borrow</a>
					 <br>
					 <a href="NewFile.html?a=${loop.index + 1}">add volume</a>
			</c:forEach>
		</table>
		<br>
	</c:if>
</body>
</html>
