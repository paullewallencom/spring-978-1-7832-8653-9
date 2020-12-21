<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



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
