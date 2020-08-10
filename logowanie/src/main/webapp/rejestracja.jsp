<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Rejestracja</title>
	</head>
	<body>
		<p style="color: red">${error}</p>
		<form action="rejestracja" method="post">
		    <div class="divForm"> 
			    <div class="label">Nazwa użytkownika: </div>
			    <input type="text" name="username" value="${username}"
	        </div>
	        <div class="divForm">
			    <div class="label">Hasło:</div>
			    <input type="password" name="password" value="${password}"
	        </div>
	        <div class="divForm">
			    <div class="label">Potwierdź hasło:</div>
			    <input type="password" name="confirmPassword" value="${confirmPassword}"
	        </div>
	        <div class="divForm">
			    <div class="label">Adres e-mail:</div>
			    <input type="text" name="email" value="${email}"
	        </div>
	        <div class="divForm">
			    <input type="submit" value="Zarejestruj">
			</div>
		</form>
	</body>
</html>