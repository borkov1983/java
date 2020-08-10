<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Harmonogram rat</title>
	</head>
	<body>
	<table>
		<td>Numer raty</td>
        <td>Kwota kapitału</td>
        <td>Kwota odsetek</td>
        <td>Opłaty stałe</td>
        <td>Całkowita kwota raty</td>
	    <c:forEach items="${raty}" var="rata">
	        <tr>
	            <td>${rata.numer}</td>
	            <td>${rata.kwotaKapitalu}</td>
	            <td>${rata.kwotaOdsetek}</td>
	            <td>${rata.oplataStala}</td>
	            <td>${rata.kosztCalkowity}</td>
	        </tr>
	    </c:forEach>
	</table>
	</body>
</html>