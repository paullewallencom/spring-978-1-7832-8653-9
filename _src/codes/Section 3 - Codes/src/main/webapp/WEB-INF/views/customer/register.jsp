<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body>
	<form:form name="input" action="users" method="post"
		modelAttribute="user">
		Username: <form:input type="text" path="name" />
		<form:errors path="name" />
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