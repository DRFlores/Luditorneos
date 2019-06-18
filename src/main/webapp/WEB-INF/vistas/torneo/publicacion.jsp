<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>	${torneo.descripcion} </h1>

        <p><span>${torneo.getOrganizador().nick}  los invita al torneo de ${torneo.juego.descripcion}
    ${torneo.modalidad.descripcion}
    a las ${torneo.getHorarioHHss()} hrs el día ${torneo.getFechaDDMMAAAA()}</span></p>
        <p> Los premios son: </p>
        <p>Primer premio: ${torneo.primerPremio} monedas</p>
        <p>Segundo premio: ${torneo.segundoPremio} monedas</p>
        <p>Tercer premio: ${torneo.tercerPremio} monedas</p>

        <c:if test="${not empty sala}">
            <p> El torneo se realizará en la sala: <p>
            <a href="${sala}">${sala}</a>
        </c:if>

        <p>Los esperamos!</p>
        <br>
         <spring:url value="/send-mail" var="mailActionUrl" />
         <form:form method="post" action="${mailActionUrl}" modelAttribute="torneo">
             <form:input cssStyle="display: none" value="${torneo.id}" path="id"/>
             <input type="submit" value="Apuntarme!!" class="btn btn-primary" />
         </form:form>
        <%@ page import="ar.edu.unlam.tallerweb1.modelo.Modalidad" %>
        <c:if test="${torneo.modalidad != Modalidad.INDIVIDUAL}">
            <p><small>*Los premios se dividen entre los participantes ganadores</small></p>
            <p><small>Por ejemplo: un primer premio de 50 monedas para un equipo de 2 participantes
                es un total de 25 monedas para cada uno</small></p>
        </c:if>

    </c:if>

</div>

</body>
</html>