<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

    <p><span>${torneo.getOrganizador().nick}  los invita al torneo de ${torneo.juego.descripcion} ${torneo.modalidad.descripcion}a las ${torneo.getHorarioHHss()} hrs el día ${torneo.getFechaDDMMAAAA()}</span></p>
    <p> Los premios son: </p>
    <p>${torneo.premios}</p>
      
      <c:if test="${not empty sala}">
      <p> El torneo se realizará en la sala: <p>
      <a href="${sala}">${sala}</a>
      </c:if>
      
      <p>Los esperamos!</p>
    <span class="bg${torneo.estado.color}">Estado del torneo: Torneo ${torneo.estado.descripcion}</span>
    <br>
    <spring:url value="/send-mail" var="mailActionUrl" />
    <form:form method="post" action="${mailActionUrl}">
        <input type="submit" value="Apuntarme!!" class="btn btn-primary" />
    </form:form>
</c:if>

</div>

</body>
</html>