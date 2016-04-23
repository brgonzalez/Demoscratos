<!DOCTYPE html>
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
		<div class = "header">
			<nav  id = "header"class="navbar navbar-default">
  				<div class="container-fluid">
    			<!-- Brand and toggle get grouped for better mobile display -->
    				<div class="navbar-header">
      					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
      					</button>
      					<a href="/" id="name-app"class="navbar-brand">Demoscratos</a>
   					</div>

    <!-- Collect the nav links, forms, and other content for toggling -->
	    			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      				<ul class="nav navbar-nav">
					    </ul>
	      
	      				<ul class="nav navbar-nav navbar-right">
	        				<li class="dropdown"><a href="#" id ="user-header" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario <span class="caret"></span></a>
	          					<ul class="dropdown-menu">
						            <li><a href="/settings-profile">Configuración</a></li>
						            <li><a href="/login">Cerrar sesión</a></li>

	          					</ul>
	        				</li>
	      				</ul>
	   				 </div><!-- /.navbar-collapse -->
	  			</div><!-- /.container-fluid -->
			</nav>
		</div>


		<div class = "container">

			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">
			</div>


			<div class = "settings col-xs-12 col-sm-12 col-md-2 col-lg-2">

				<div class = "side-bar">
					<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			    		<li ><a  href="./settings-profile.html">Perfil</a></li>
			    		<li class= "active" ><a id ="settings-active" href=" ">Contraseña</a></li>
			    		<li><a href="./setting-notification.html">Notificaciones</a></li>
			    		<li><a  href="./settings-ring.html">Anillo de Confianza</a></li>
		  			</ul>
				</div>

			</div>

			<div class = "space-setting col-xs-12 col-sm-12 col-md-6 col-lg-6">

				<form>
					<h3>Cambie su contraseña </h3>

  					<fieldset class="form-group">
					    <label for="profile-inputName">Ingrese la contraseña actual</label>
					    <input type="password" class="form-control" id="m1-InputName" placeholder="Contraseña actual">
  					</fieldset>

  					<fieldset class="form-group">
					    <label for="profile-inputLastName">Ingrese la nueva contraseña</label>
					    <input type="password" class="form-control" id="m1-InputName" placeholder="Apellido">
  					</fieldset>

  					<fieldset class="form-group">
    					<label for="profile-inputEmail">Ingrese nuevamente la nueva contraseña</label>
    					<input type="password" class="form-control" id="inputEmail" placeholder="Email">
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