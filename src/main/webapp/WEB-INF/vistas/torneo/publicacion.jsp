<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty error}">
      <h4><span>${error}</span></h4>
       <h4><span>${id}</span></h4>
       <br>
</c:if>

<c:if test="${not empty torneo}">
		<h1>	${torneo.descripcion} </h1>
      <p><span>${organizador.nick} los invita a su torneo de ${torneo.juego.descripcion} ${torneo.modalidad.descripcion} a las ${torneo.horario} el ${torneo.dia}</span></p>
      <p> Los premios son: </p>
      <p>${torneo.premios}</p>
      <p>Los esperamos!</p>
       <br>
</c:if>


</body>
</html>