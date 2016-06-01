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
			    		<li ><a  href="settings-profile">Perfil</a></li>
			    		<li class= "active" ><a id ="settings-active" href=" ">Contraseña</a></li>
			    		<li><a href="#">Notificaciones</a></li>
			    		<li><a  href="settings-ring">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "space-setting col-xs-12 col-sm-12 col-md-6 col-lg-6">
			
				<div style ="display: ${success};"class="alert alert-success" role="alert" >
				  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  	<strong>Éxito!</strong> Se ha actualizado su perfil.
				</div>

				<form:form action="settings-password" method ="post">
					<h3>Cambie su contraseña </h3>

  					<fieldset class="form-group">
					    <label for="profile-inputName">Ingrese la contraseña actual</label>
					    <input type="password" class="form-control" placeholder="contraseña actual" name ="currentPassword">
  					</fieldset>

  					<fieldset class="form-group">
					    <label for="profile-inputLastName">Ingrese la nueva contraseñaa</label>
					    <input type="password" class="form-control"  placeholder="nueva contraseña" name = "newPassword">
  					</fieldset>

  					<fieldset class="form-group">
    					<label for="profile-inputEmail">Ingrese nuevamente la nueva contraseña</label>
    					<input type="password" class="form-control"  placeholder="nueva contraseña">
  					</fieldset>


  					<HR width=50% align="center">

	  				<input  id ="button-save"type="submit" class="btn btn-primary" value="Guardar"/>

  					

  					
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