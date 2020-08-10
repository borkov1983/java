<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Profil</title>
	</head>
	<body>
		<h1>Mój profil</h1>
		<span>Nazwa użytkownika: ${user.username}</span> <br />
		<span>E-mail: ${user.email}</span> <br />
		<c:if test = "${user.isPremium == 'true'}"><a href="/premium">Podstrona premium!</a> <br /></c:if>
		<c:if test = "${user.isAdmin == 'true'}"><a href="/admin">Panel admina!</a> <br /></c:if>
		<a href="/logout">Wyloguj</a>
	</body>
</html>