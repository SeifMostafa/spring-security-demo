<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Project</title>
</head>
<body>
	<h3>What a wonderful world!</h3>

	<hr>

	
		<p>
			User:
			<security:authentication property="principal.username" />
			<br> <br> Role(s):
			<security:authentication property="principal.authorities" />
		</p>
	


	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership
			meeting</a> <br> <br> <a
			href="${pageContext.request.contextPath}/system">System page</a>
	</p>


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>