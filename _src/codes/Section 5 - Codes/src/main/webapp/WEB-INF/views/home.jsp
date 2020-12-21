<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<title>Home</title>
</head>
<body>

<div style="float:right">
	<a href="users?create"><spring:message code="homePage.registerLink"/></a>
</div>


<h1>
	<spring:message code="welcome"/>  
</h1>

<h2> <spring:message code="featuredProducts"/> </h2>
<c:forEach var="item" items="${featuredProducts}">
	<c:out value="${item.name}"/> <br/>
</c:forEach>

<h2> <spring:message code="categories"/> </h2>
<c:forEach var="category" items="${allCategories}">
	<a href="categories/category/${category.id}"><c:out value="${category.name}"/></a> <br/>
</c:forEach>


</body>
</html>
