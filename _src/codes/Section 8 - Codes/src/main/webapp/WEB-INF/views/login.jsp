<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<title>Login</title>
</head>
<body>
${loginError}
<form action='login' method="post">
    <fieldset>
        <legend>login</legend>
        <table>
        <tr>
            <td>user name: </td>
            <td><input type="text" id="userId" name="userId" placeholder="user name"/></td>
        </tr>
        <tr>
            <td>password: </td>
            <td><input type="password" id="password" name="password" placeholder="password"/></td>
        </tr>
        <tr><td colspan="2" align="center"><button id="loginButton">login</button></td></tr>
        </table>
    </fieldset>
</form>


</body>
</html>