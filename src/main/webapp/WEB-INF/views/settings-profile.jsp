resources/<!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/semantic/dist/semantic.min.css">
		<script src="/demoscratos/resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/settings.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

	</head>

	<body>
		<jsp:include page="includes/header.jsp" />


		<div class = "container">

			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">
			</div>


			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">

				<div class = "side-bar">
					<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			    		<li class= "active" ><a id ="settings-active" href="./">Perfil</a></li>
			    		<li><a href="./settings-password.html">Contraseña</a></li>
			    		<li><a href="./setting-notification.html">Notificaciones</a></li>
			    		<li><a  href="./settings-ring.html">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "space-setting col-xs-12 col-sm-12 col-md-6 col-lg-6">

				<form>
					<h3>Perfil </h3>

  					<fieldset class="form-group">
					    <label for="profile-inputName">Nombre</label>
					    <input type="text" class="form-control" id="m1-InputName" placeholder="Nombre">
  					</fieldset>

  					<fieldset class="form-group">
					    <label for="profile-inputLastName">Apellido</label>
					    <input type="text" class="form-control" id="m1-InputName" placeholder="Apellido">
  					</fieldset>

  					<fieldset class="form-group">
    					<label for="profile-inputEmail">Correo</label>
    					<input type="email" class="form-control" id="inputEmail" placeholder="Email">
  					</fieldset>


  					<HR width=50% align="center">

  					<button type="submit" id="button-save" class="btn btn-primary button-save" >Guardar</button>

  					

  					
				</form>


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