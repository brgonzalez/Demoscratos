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



		<link rel="stylesheet" type="text/css" href="resources/semantic/dist/semantic.min.css">
		<script src="resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/general.css">

		<link rel="stylesheet" type="text/css" href="resources/styles/settings.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">



	</head>

	<body>
		<jsp:include page="includes/header.jsp" />



		<div class = "container">

			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">
			</div>


			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">

				<div class = "side-bar">
					<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			    		<li><a href="./settings-profile.html">Perfil</a></li>
			    		<li><a href="./settings-password.html">Contraseña</a></li>
			    		<li><a href="./settings-notification.html">Notificaciones</a></li>
			    		<li class= "active"><a id ="settings-active" href="./settings-ring.html">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "space-setting col-xs-12 col-sm-12 col-md-6 col-lg-6">

				<div id ="create-ring">
					<button style="display=${displayButton}" type="submit" class="btn btn-primary">Crear</button>
				</div>
				<div style="display:$'{displayShow-ring}';" id= "show-ring">
					<h3>Amigo 1 </h3>
					
					<div id="info-m1">
		 				<label>${user.userName} </label>
		 				<label>${user.email}</label>
		  			</div>
		  			<h3>Amigo 3 </h3>
					
					<div id="info-m1">
		 				<label>${user.userName} </label>
		 				<label>${user.email}</label>
		  			</div>
		  			<h3>Amigo 3 </h3>
					
					<div id="info-m1">
		 				<label>${user.userName} </label>
		 				<label>${user.email}</label>
		  			</div>
						
					

	  				<button onclick="$('#show-ring').hide(); $('#modify-ring').show()" type="submit" class="btn btn-primary">Modificar</button>

	  			</div>

				<form:form id = "modify-ring" style="display:none;" action="settings-ring" method="post">
					
						<h3>Amigo 1 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input name ="emailMember1"type="email" class="form-control" id="inputEmail" placeholder="Email" value="${user.email}">
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  					
	  					<h3>Amigo 2 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input name ="emailMember2" type="email" class="form-control" id="inputEmail" placeholder="Email" value="${user.email}">
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  					
	  					<h3>Amigo 3 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input  name ="emailMember3" type="email" class="form-control" id="inputEmail" placeholder="Email" value="${user.email}">
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  				

	  				<button onclick="$('#modify-ring').hide(); $('#show-ring').show()" type="submit" class="btn btn-primary">Guardar</button>


  					
				</form:form>


			<div>	

			<div class = "settings col-xs-12 col-sm-12 col-md-3 col-lg-3">
			</div>


		</div>


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>