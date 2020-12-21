<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Spring Chocolate Store!  
</h1>

<h2> Today's featured products:</h2>
<c:forEach var="item" items="${featuredProducts}">
	<c:out value="${item.productName}"/> <br/>
</c:forEach>

</body>
</html>
