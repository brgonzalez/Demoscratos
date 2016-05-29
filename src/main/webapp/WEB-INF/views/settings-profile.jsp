<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">
		
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/settings.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

	</head>

	<body class="wall">
		<jsp:include page="includes/header.jsp" />


		<div class = "container">

			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">
			</div>


			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">

				<div class = "side-bar">
					<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			    		<li class= "active" ><a id ="settings-active" href="">Perfil</a></li>
			    		<li><a href="settings-password">Contraseña</a></li>
			    		<li><a href="setting-notification">Notificaciones</a></li>
			    		<li><a  href="settings-ring">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "settings col-xs-12 col-sm-12 col-md-6 col-lg-6">

				<form:form action="settings-profile" method="post">
					<h3>Perfil </h3>

  					<fieldset class="form-group">
					    <label>Nombre</label>
		    				<input name ="name"type="text" class="form-control"  placeholder="nombre" value="${user.name}">
  					</fieldset>

  					<HR width=50% align="center">

  					<fieldset class="form-group">
					    <label >Apellido</label>
		    			<input name ="lastName"type="text" class="form-control"  placeholder="apellido" value="${user.lastName}">
  					</fieldset>

  					<HR width=50% align="center">

  					<fieldset class="form-group">
    					<label>Correo</label>
		    				<input name ="email"type="text" class="form-control"  placeholder="correo" value="${user.email}" disabled>
  					</fieldset>

  					<HR width=50% align="center">

  					<button type="submit" id="button-save" class="btn btn-primary button-save" >Guardar</button>
  				</form:form>

			</div>
			
			<div class = "settings col-xs-12 col-sm-12 col-md-3 col-lg-3">
			</div>

		</div>


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>