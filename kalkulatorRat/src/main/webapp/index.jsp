<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Kalkulator rat</title>
		<style><%@include file="style.css"%></style>
	</head>
	<body>
		<form action="kalkulator" method="post">
		    <div class="divForm"> 
			    <div class="label">Kwota kredytu: </div>
			    <input type="text" name="kwotaKredytu" value="${kwotaKredytu}"
			    <c:if test="${fn:contains(bledy, 'kwotaKredytu')}">
		            class="error"
		        </c:if>>
	        </div>
	        <div class="divForm">
			    <div class="label">Ilość rat:</div>
			    <input type="text" name="iloscRat" value="${iloscRat}"
			    <c:if test="${fn:contains(bledy, 'iloscRat')}">
		            class="error"
		        </c:if>>
	        </div>
	        <div class="divForm">
			    <div class="label">Oprocentowanie:</div>
			    <input type="text" name="oprocentowanie" value="${oprocentowanie}"
			    <c:if test="${fn:contains(bledy, 'oprocentowanie')}">
		            class="error"
		        </c:if>>
	        </div>
	        <div class="divForm">
			    <div class="label">Opłata stała: </div><input type="text" name="oplataStala" value="${oplataStala}"
			    <c:if test="${fn:contains(bledy, 'oplataStala')}">
		            class="error"
		        </c:if>>
	        </div>
	        <div class="divForm">
			    <div class="label">Typ rat:</div>
			    <select name="typRat">
				  <option value="malejace" <c:if test = "${typRat == 'malejace'}"> selected </c:if>>Malejące</option>
				  <option value="stale" <c:if test = "${typRat == 'stale'}"> selected </c:if>>Stałe</option>
				</select>
			    <input type="submit" value="Oblicz">
			</div>
		</form>
	</body>
</html>