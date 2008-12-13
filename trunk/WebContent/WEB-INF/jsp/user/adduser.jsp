<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Register User"/>
	<jsp:param name="tab" value="register"/>
</jsp:include>
<h3>Register User</h3>
<form:form method="post" commandName="user">
	<table cellspacing="0" cellpadding="5">
		<tr>
			<td class="rightAlign">Login:</td>
			<td><c:if test="${user.login == null }">
				<form:input path="login" />
			</c:if> <c:if test="${user.login != null }">
				<form:input path="login" readonly="true" />
			</c:if></td>
			<td><form:errors path="login" cssClass="error" /></td>
		</tr>

		<c:if test="${user.login == null }">
			<tr>
				<td class="rightAlign">Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" />
				</td>
			</tr>
		</c:if>

		<tr>
			<td class="rightAlign">Firstname:</td>
			<td><form:input path="firstname" /></td>
			<td><form:errors path="firstname" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td class="rightAlign">Lastname:</td>
			<td><form:input path="lastname" /></td>
			<td><form:errors path="lastname" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td class="rightAlign">Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr>
		<td>Address Information</td>
		</tr>
		<tr>
			<td class="rightAlign">Street:</td>
			<td><form:input path="address.street" /></td>
			<td><form:errors path="address.street" cssClass="error" /></td>
		</tr>
		<tr>
			<td class="rightAlign">City:</td>
			<td><form:input path="address.city" /></td>
			<td><form:errors path="address.city" cssClass="error" /></td>
		</tr>
		<tr>
			<td class="rightAlign">State:</td>
			<td><form:input path="address.state" /></td>
			<td><form:errors path="address.state" cssClass="error" /></td>
		</tr>
		<tr>
			<td class="rightAlign">Country:</td>
			<td><form:input path="address.country" /></td>
			<td><form:errors path="address.country" cssClass="error" /></td>
		</tr>
		<tr>
			<td class="rightAlign">Zipconde:</td>
			<td><form:input path="address.zipcode" /></td>
			<td><form:errors path="address.zipcode" cssClass="error" /></td>
		</tr>
		
		<tr><td>&nbsp;</td><td><input type="submit" value="Submit"></td>
	</table>
</form:form>

<br/>

<jsp:include page="../footer.jsp"/>