<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Proximos torneos</title>
</head>
<body>

<div class = "container">
<h1 class="text-center">Próximos torneos</h1>
	
<c:if test="${not empty error}">
     <h4><span class="alert alert-danger">${error}</span></h4>
     <br>
</c:if>
	
<c:if test="${not empty torneos}">
<c:forEach var="torneo" items="${torneos}">    
     
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">${torneo.getFechaDDMMAAAA()} - ${torneo.juego.descripcion}
		${torneo.modalidad.descripcion} a las ${torneo.getHorarioHHss()} hrs </h3>
	</div>
	<div class="panel-body">
		<span>Total de premios a repartir: 
		${torneo.getPremiosTotalesARepartir()} monedas</span>
		<a href="torneo/${torneo.id}" class="btn btn-info pull-right" role="button">Ver Detalles</a>
		<p>Organiza: ${torneo.getOrganizador().nick}</p>
		
  	</div>
</div>
</c:forEach>    
</c:if>		
			
</div>

</body>
</html>