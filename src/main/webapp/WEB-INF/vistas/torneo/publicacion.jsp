<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Torneos</title>
</head>
<body>

<div class="container text-center">
<c:if test="${not empty error}">
    <h4 class="alert alert-danger"><span>${error}</span></h4>
    <br>
</c:if>

<c:if test="${not empty torneo}">
		<h1>${torneo.descripcion} </h1>

      <p><span>${torneo.getOrganizador().nick}  los invita al torneo de ${torneo.juego.descripcion} ${torneo.modalidad.descripcion} 
      a las ${torneo.getHorarioHHss()} hrs el día ${torneo.getFechaDDMMAAAA()}</span></p>
      <p> Los premios son: </p>
      <p>${torneo.premios}</p>
      
      <c:if test="${not empty sala}">
      <p> El torneo se realizará en la sala: <p>
      <a href="${sala}">${sala}</a>
      </c:if>
      
      <p>Los esperamos!</p>


		<span class="bg${torneo.estado.color}">Estado del torneo: Torneo ${torneo.estado.descripcion}</span>
    <br>
    <button type="button" class="btn btn-primary">Apuntarme!!</button>
       
</c:if>

</div>

</body>
</html>