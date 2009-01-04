<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Login"/>
	<jsp:param name="tab" value="profile"/>
</jsp:include>
	<form name='f' action='/kubja/j_spring_security_check' method='POST'>
	<table>
	    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
	    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
	    <tr><td><input type='checkbox' name='_spring_security_remember_me'/></td><td>Remember me on this computer.</td></tr>
	    <tr><td colspan='2'><input name="submit" type="submit"/></td></tr>
	    <tr><td colspan='2'><input name="reset" type="reset"/></td></tr>
	</table>
	</form>
<jsp:include page="../footer.jsp"/>