<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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


	<%-- <p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>



	<p>

		<security:authorize access="hasRole('MANAGER')">


			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a>

		</security:authorize>
		<br> <br>

		<security:authorize access="hasRole('ADMIN')">

			<a href="${pageContext.request.contextPath}/system">System page</a>

		</security:authorize>
	</p> --%>


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>