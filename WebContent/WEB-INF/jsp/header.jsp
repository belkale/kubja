<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head><title>${param.title }</title>
<link rel="stylesheet" type="text/css" href="/kubja/themes/classic/style.css" media="all" /> 
</head>
<body>
<div id="header">
<div class="userLogin">
	Hello <security:authentication property="principal.username"/>! | <a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</div>
<h1>Kubja</h1>
<h2>A Sample Application Using Spring and Hibernate</h2>
</div>
<div id="menu">
	<ul>

		<!--
				Each list item below represents a tab in the menu. Set the class
				of any list item to 'active' to make it, well, active.
		-->
		<c:if test='${param.tab eq "home"}'><li id="first" class="active"></c:if><c:if test='${param.tab ne "home"}'><li id="first"></c:if>
			<a href="<c:url value='/user/userslist.htm'/>">Homepage</a></li>
		<c:if test='${param.tab eq "register"}'><li class="active"></c:if><c:if test='${param.tab ne "register"}'><li></c:if>
			<a href="<c:url value='/user/adduser.htm'/>">Register User</a></li>
		<c:if test='${param.tab eq "profile"}'><li class="active">
			<a href="<c:url value='/user/viewuser.htm'/>">User Profile</a></li>
		</c:if>
	</ul>
	<div></div>
</div>

<div id="container">
