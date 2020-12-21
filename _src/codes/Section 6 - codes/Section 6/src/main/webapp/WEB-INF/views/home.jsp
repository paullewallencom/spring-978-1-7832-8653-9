<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<title>Home</title>
</head>
<body>

<div style="float:right">
<c:choose>
	<c:when test = "${empty loggedInUser.userId}">
		<a href="users?create"><spring:message code="homePage.registerLink"/></a> &nbsp;
		<a href="login"><spring:message code="homePage.loginLink"/></a>
	</c:when>
	<c:otherwise>
		Hello ${loggedInUser.firstName}! &nbsp;
		<a href="logout"><spring:message code="homePage.logoutLink"/></a>
	</c:otherwise>
</c:choose>

</div>

<h1>
	<spring:message code="welcome"/>  
</h1>

<h2> <spring:message code="featuredProducts"/> </h2>
<c:forEach var="item" items="${featuredProducts}">
	<c:out value="${item.name}"/> &nbsp; 
	<a href="cart/add/${item.id}">Add to cart</a>
	<br/>
</c:forEach>

<h2> <spring:message code="categories"/> </h2>
<c:forEach var="category" items="${allCategories}">
	<a href="categories/category/${category.id}"><c:out value="${category.name}"/></a> <br/>
</c:forEach>


</body>
</html>
