<!DOCTYPE HTML>
<%@include file="../../WEB-INF/navigation/Config.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
     <style>
      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
      body {
  font-family: "Open Sans", sans-serif;
  height: 100vh;

/*     background: url("https://www.tece.com/themes/custom/tece/assets/svg/logo_tece_rgb.svg") ; */
/*   background: url("http://i.imgur.com/HgflTDf.jpg") 50% fixed; */
  background-size: cover;
}

@keyframes spinner {
  0% {
    transform: rotateZ(0deg);
  }
  100% {
    transform: rotateZ(359deg);
  }
}
* {
  box-sizing: border-box;
}

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
  background: rgba(4, 40, 68, 0.85);
}

.login {
  border-radius: 2px 2px 5px 5px;
  padding: 10px 20px 20px 20px;
  width: 100%;
  height: 100%;
  min-width: 480px;
  background: #ffff00;
  position: center;
  padding-bottom: 80px;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3);
}
.login.loading button {
  max-height: 100%;
  padding-top: 50px;
}
.login.loading button .spinner {
  opacity: 1;
  top: 40%;
}
.login.ok button {
  background-color: #8bc34a;
}
.login.ok button .spinner {
  border-radius: 0;
  border-top-color: transparent;
  border-right-color: transparent;
  height: 20px;
  animation: none;
  transform: rotateZ(-45deg);
}
.login input {
  display: block;
  padding: 15px 10px;
  margin-bottom: 10px;
  width: 100%;
  border: 1px solid #ddd;
  transition: border-width 0.2s ease;
  border-radius: 2px;
  color: #ccc;
}
.login input + i.fa {
  color: #fff;
  font-size: 1em;
  position: absolute;
  margin-top: -47px;
  opacity: 0;
  left: 0;
  transition: all 0.1s ease-in;
}
.login input:focus {
  outline: none;
  color: #444;
  border-color: #2196F3;
  border-left-width: 35px;
}
.login input:focus + i.fa {
  opacity: 1;
  left: 30px;
  transition: all 0.25s ease-out;
}
.login a {
  font-size: 0.8em;
  color: #2196F3;
  text-decoration: none;
}
.login .title {
  color: #000033;
  font-size: 2.2em;
  font-weight: bold;
  margin: 10px 0 30px 0;
  border-bottom: 1px solid #eee;
  padding-bottom: 20px;
  align:center
}
.login button {
  width: 100%;
  height: 100%;
  padding: 10px 10px;
  background: #ffff00;
  color: #ffff00;
  display: block;
  border: none;
  margin-top: 20px;
  position: absolute;
  left: 0;
  bottom: 0;
  max-height: 60px;
  border: 0px solid rgba(0, 0, 0, 0.1);
  border-radius: 0 0 2px 2px;
  transform: rotateZ(0deg);
  transition: all 0.1s ease-out;
  border-bottom-width: 7px;
}
.login button .spinner {
  display: block;
  width: 40px;
  height: 40px;
  position: absolute;
  border: 4px solid #ffffff;
  border-top-color: rgba(255, 255, 255, 0.3);
  border-radius: 100%;
  left: 50%;
  top: 0;
  opacity: 0;
  margin-left: -20px;
  margin-top: -20px;
  animation: spinner 0.6s infinite linear;
  transition: top 0.3s 0.3s ease, opacity 0.3s 0.3s ease, border-radius 0.3s ease;
  box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.2);
}
.login:not(.loading) button:hover {
  box-shadow: 0px 1px 3px #2196F3;
}
.login:not(.loading) button:focus {
  border-bottom-width: 4px;
}

footer {
  display: block;
  padding-top: 50px;
  text-align: center;
  color: #ddd;
  font-weight: normal;
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.2);
  font-size: 0.8em;
}
footer a, footer a:link {
  color: #fff;
  text-decoration: none;
}

html, body {
height: 100%;
}

    </style>

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
		<form action="${pageContext.request.contextPath}${UrlConstants.C_JITEM_DISPATCH}"
		 method="GET" class="login">
		 <p class="title">
			Item name:
			<c:out value="${jitemInstanse.name}" />
			<br>OrderNo:
			<c:out value="${jitemInstanse.orderNo}" />
			</p>
			<!-- 			<br><c:out value="${pageContext.request.contextPath}" />  -->
			<br>
			<p class="title">Quantity:</p>
			<br>
			<input type="number" name= "${ViewConstants.JITEM_QUANTITY}" value="1" class="title" />
			<input type="hidden" name="${ViewConstants.JITEM_MODEL_INDEX}" value="${jitemInstanse.orderNo}">
			<br>
			<input type="submit" value="Dispatch" class="title"/>
		</form>
		</h1>
	</c:if>
	<c:if test="${jitemInstanse == null}">
		<p>item not found</p>
	</c:if>
	</div>
</body>
</html>
