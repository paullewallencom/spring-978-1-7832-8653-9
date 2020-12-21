<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<title>Register</title>
</head>
<body>
	<form:form name="input"  method="post"
		modelAttribute="product" action="products">
		<div>
			<label>Name: </label>
			<form:input type="text" path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<label>Description: </label>
			<form:input type="text" path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<label>Category:</label>
			<form:select path="category" items="${categories}" itemLabel="name" itemValue="id" />
		</div>
		<div>
			<label>Featured?</label>
			<form:checkbox path="featured" /> 
		</div>
		<div>
			<input type="submit" value="Submit">
		</div>


	</form:form>
</body>
</html>