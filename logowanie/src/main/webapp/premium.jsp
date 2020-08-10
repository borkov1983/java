<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Panel Premium</title>
	</head>
	<body>
	<table>
		<td>Nazwa użytkownika</td>
        <td>Email</td>
        <td>Użytkownik premium</td>
	    <c:forEach items="${users}" var="user">
	        <tr>
	            <td>${user.username}</td>
	            <td>${user.email}</td>
	            <td>
		            <c:if test = "${user.isPremium == 'true'}">TAK</c:if>
		            <c:if test = "${user.isPremium == 'false'}">NIE</c:if>            
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<a href="/profile">Wroć do profilu</a>
	</body>
</html>