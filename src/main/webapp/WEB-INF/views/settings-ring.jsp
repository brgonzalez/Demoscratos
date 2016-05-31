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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/settings-ring.css">

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
			    		<li><a href="settings-profile">Perfil</a></li>
			    		<li><a href="settings-password">Contraseña</a></li>
			    		<li><a href="">Notificaciones</a></li>
			    		<li class= "active"><a id ="settings-active" href="settings-ring">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "space-setting col-xs-12 col-sm-12 col-md-6 col-lg-6">

				<div id ="create-ring">
					<button onclick="$('#create-ring').hide(); $('#modify-ring').show()" id ="button-save"style="display:${displayButton};" type="submit" class="btn btn-primary button-save">Crear</button>
				</div>
				<div style="display:${sring};" id= "show-ring">
					<h3 class="friend">Amigo 1 </h3>
					<div class = "data">
						<label>Nombre</label>
						<label>Correo</label>
		 				<label>${member1.name} ${member1.lastName} </label>
		 				<label>${member1.email}</label>
		  			</div>
		  			
		  			<hr>
		  			
		  			<h3 class="friend">Amigo 2 </h3>
					<div class = "data">
						<label>Nombre</label>
						<label>Correo</label>			
		 				<label>${member2.name} ${member2.lastName}</label>
		 				<label>${member2.email}</label>
		  			</div>
		  			<hr>
		  			<h3 class="friend">Amigo 3 </h3>
					<div class = "data">
						<label>Nombre</label>
						<label>Correo</label>
		 				<label>${member3.name}${member3.lastName}</label>
		 				<label>${member3.email}</label>
		  			</div>
		  			
		  			<hr>
						

	  				<button onclick="$('#show-ring').hide(); $('#modify-ring').show()" type="submit" id ="button-save"class="btn btn-primary">Modificar</button>

	  			</div>

				<form:form id = "modify-ring" style="display:${modify-ring};" action="settings-ring" method="post">
					
						<h3>Amigo 1 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input name ="emailMember1"type="text" class="form-control" id="inputEmail" placeholder="Email" value="${member1.email}" required>
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  					
	  					<h3>Amigo 2 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input name ="emailMember2" type="text" class="form-control" id="inputEmail" placeholder="Email" value="${member2.email}" required>
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  					
	  					<h3>Amigo 3 </h3>
						<div>
		  					<fieldset class="form-group" >
		    					<label for="m1-inputEmail">Correo</label>
		    					<input  name ="emailMember3" type="email" class="form-control" id="inputEmail" placeholder="Email" value="${member3.email}"required >
		  					</fieldset>
		  				</div>
	
	  					<HR width=50% align="center">
	  				

	  				<input  id ="button-save"type="submit" class="btn btn-primary" value="Guardar"/>


  					
				</form:form>


			<div>	

			<div class = "settings col-xs-12 col-sm-12 col-md-3 col-lg-3">
			</div>


		</div>


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>