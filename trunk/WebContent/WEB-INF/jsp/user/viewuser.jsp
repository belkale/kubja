<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="View User Profile"/>
	<jsp:param name="tab" value="profile"/>
</jsp:include>
<h3>View User Profile</h3>
<table>

<tr><td class="rightAlign">Login:</td><td>${user.login }</td></tr>
<tr><td class="rightAlign">Firstname:</td><td>${user.firstname }</td></tr>
<tr><td class="rightAlign">Lastname:</td><td>${user.lastname }</td></tr>
<tr><td class="rightAlign">Email:</td><td>${user.email }</td></tr>

<c:if test="${user.address != null }">
<tr><td>Address Information</td></tr>
<tr><td class="rightAlign">Street:</td><td>${user.address.street }</td></tr>
<tr><td class="rightAlign">City:</td><td>${user.address.city }</td></tr>
<tr><td class="rightAlign">State:</td><td>${user.address.state }</td></tr>
<tr><td class="rightAlign">Country:</td><td>${user.address.country }</td></tr>
<tr><td class="rightAlign">Zipcode:</td><td>${user.address.zipcode }</td></tr>
</c:if>
		
</table>

<jsp:include page="../footer.jsp"/>