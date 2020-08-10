<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Panel Admin</title>
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
		            <a href="/changePremium?username=${user.username}">
			            <c:if test = "${user.isPremium == 'true'}">TAK</c:if>
			            <c:if test = "${user.isPremium == 'false'}">NIE</c:if>            
		            </a>   
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<a href="/profile">Wroć do profilu</a>
	</body>
</html>