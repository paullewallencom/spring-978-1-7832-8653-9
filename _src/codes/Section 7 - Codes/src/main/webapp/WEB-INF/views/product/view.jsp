<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View product</title>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
</head>
<body>

	<h2>View Product</h2>
	<div> Name: ${product.name} </div>
	<div> description: ${product.description}</div>
	<div> Category: ${product.category.name}</div>
	<div> Featured?: ${product.featured}</div>

<a href="products/product/${product.id}/edit">Edit product</a>

</body>
</html>