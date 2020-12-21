<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<title>Register</title>
</head>
<body>
	<form:form name="input"  method="post"
		modelAttribute="user" servletRelativeAction="/users">
		Username: <form:input type="text" path="userId" />
		<form:errors path="userId" />
		<br />
		Password: <form:input type="text" path="password" />
		<form:errors path="password" />
		<br />
		Email: <form:input type="text" path="email" />
		<form:errors path="email" />
		<br />
		First Name: <form:input type="text" path="firstName" />
		<form:errors path="firstName" />
		<br />
		Last Name: <form:input type="text" path="lastName" />
		<form:errors path="lastName" />
		<br />
		<input type="submit" value="Submit">
		<br />
	</form:form>
</body>
</html>