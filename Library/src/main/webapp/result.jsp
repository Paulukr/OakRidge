<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../WEB-INF/navigation/Config.jsp"%>

<html>
<head>
<title>Title</title>
</head>
<body bgcolor="#d3d3d3">
	<br>
	<br>
	<br>
	<!-- height="50" -->
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
		<c:forEach items="${list}" var="s">
			<tr>
				<td style="text-indent: 10px"><c:out value="${s.name}" /></td>
				<td style="text-indent: 10px"><c:out value="${s.rate}" /></td>
				<td style="text-indent: 10px"><c:out value="${s.ask}" /></td>
				<td style="text-indent: 10px"><c:out value="${s.bid}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p align="center">
		<a href="index.jsp"><b>Return to main</b></a>
	</p>
</body>
</html>
