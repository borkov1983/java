<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Logowanie</title>
	</head>
	<body>
		<p style="color: red">${error}</p>
		<form action="logowanie" method="post">
		    <div class="divForm"> 
			    <div class="label">Użytkownik: </div>
			    <input type="text" name="username" value="${username}">
	        </div>
	        <div class="divForm">
			    <div class="label">Hasło:</div>
			    <input type="password" name="password">
	        </div>
	        <div class="divForm">
			    <input type="submit" value="Zaloguj">
			</div>
			<a href="rejestracja.jsp">Zarejestruj się!</a>
		</form>
	</body>
</html>