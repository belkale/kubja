<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="List of All Users"/>
	<jsp:param name="tab" value="home"/>
</jsp:include>
<h3>List of All Users</h3>
<table class="list_usersList" cellpadding="5" cellspacing="0">
<tr class="list_tableHeader">
<td>Login</td>
<td>Firstname</td>
<td>Lastname</td>
<td>Email</td>
<td>&nbsp;</td>
</tr>
<c:forEach items="${usersList }" var="u" varStatus="status">
	<c:set var="viewUrl">
		<c:url value="/user/viewuser.htm"><c:param name="id" value="${u.login}"/></c:url>
	</c:set>
	<c:set var="updateUrl">
		<c:url value="/user/updateuser.htm"><c:param name="id" value="${u.login}"/></c:url>
	</c:set>

	<c:if test="${status.index%2 == 0}">
	<tr class="list_row  list_rowOdd">
	</c:if>
	<c:if test="${status.index%2 == 1}">
	<tr class="list_row">
	</c:if>
		<td><a href='${viewUrl}'>${u.login}</a></td>
		<td>${u.firstname}</td>
		<td>${u.lastname}</td>
		<td>${u.email }</td>
		<c:if test="${u.login eq user}">
			<td><a href='${updateUrl}'>Update</a></td>
		</c:if>
		<c:if test="${u.login ne user}">
			<td>&nbsp;</td>
		</c:if>
	</tr>
	
</c:forEach>
</table>

<jsp:include page="../footer.jsp"/>