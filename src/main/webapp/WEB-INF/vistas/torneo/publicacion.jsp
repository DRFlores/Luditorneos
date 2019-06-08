<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Torneos</title>
</head>
<body>

<c:if test="${not empty error}">
      <h4><span>${error}</span></h4>
       <br>
</c:if>

<c:if test="${not empty torneo}">
		<h1>	${torneo.descripcion} </h1>
      <p><span>${organizador.nick} los invita a su torneo de ${torneo.juego.descripcion} ${torneo.modalidad.descripcion} a las ${horario} hrs el ${fecha}</span></p>
      <p> Los premios son: </p>
      <p>${torneo.premios}</p>
      
      <c:if test="${not empty sala}">
      <p> El torneo se realizará en la sala: <p>
      <a href="${sala}">${sala}</a>
      </c:if>
      
      <p>Los esperamos!</p>
       <br>
</c:if>


</body>
</html>