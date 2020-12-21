<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Profile</title>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
</head>
<body>

	<h2>View Profile</h2>
	<div> Name: ${user.firstName} ${user.lastName} </div>
	<div> Email: ${user.email}</div>
	

<a href="users/user/${userId}/edit">Edit Profile</a>

</body>
</html>