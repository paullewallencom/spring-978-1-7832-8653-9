<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
</head>
<body>
	<form:form name="input" method="post" modelAttribute="user"
		action="users/user/${user.userId}">
		<form:input type="hidden" path="id" />
		<div>
			<label>Username:</label> ${user.userId}
		</div>
		<div>
			<label>Password: </label>
			<form:input type="text" path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<label>Email:</label>
			<form:input type="text" path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<label>First Name:</label>
			<form:input type="text" path="firstName" />
			<form:errors path="firstName" />
		</div>
		<div>
			<label>Last Name:</label>
			<form:input type="text" path="lastName" />
			<form:errors path="lastName" />
		</div>
		<div>
			<input type="submit" value="Submit">
		</div>
	</form:form>
</body>
</html>