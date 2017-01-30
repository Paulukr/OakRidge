<%@include file="../../WEB-INF/navigation/Config.jsp"%>


<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../../WEB-INF/navigation/Header.jsp"%>


<head>
<title>PageNotFound</title>
</head>
<body>

<body>
	<c:set var="fullName" value="${sharedId}" />
	<h1>s1: ${fullName}</h1>
	<h1>s2: ${fullName}</h1>
	<h1>s3: <c:out value= "${fullName}"></c:out></h1>
<%-- 	<h1>s4: <c:out value= "${UrlConstants.}"></c:out></h1> --%>

<%-- 	<p> <c:out value= "${fullName}"></c:out> </p> --%>
	<p align="center">PageNotFound NEW</p>
</body>

<%-- <% String sharedS = (String)request.getAttribute("sharedId"); %> --%>
<%-- 	<h1>s0: <%= sharedS %></h1> --%>

<!-- String shared = "shared"; -->
<!-- request.setAttribute("sharedId", shared); // add to request -->
<!-- request.getSession().setAttribute("sharedId", shared); // add to session -->
<!-- this.getServletConfig().getServletContext().setAttribute("sharedId", shared); // add to application context -->

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<!-- <body> -->
<%-- <cut value= "${shared}"/> --%>
<%-- <cut value= "${requestScope.shared}"/> --%>
<%-- <cut value= "${requestScope.request.shared}"/> --%>
<%-- ${shared}  --%>

<!-- //  String shared = (String)request.getAttribute("sharedId"); -->
<!-- //  String shared1 = (String)request.getSession().getAttribute("sharedId"); -->
<!-- //  String shared2 = (String)this.getServletConfig().getServletContext().getAttribute("sharedId"); -->


</html>



