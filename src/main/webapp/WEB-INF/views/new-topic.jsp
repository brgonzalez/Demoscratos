<!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="resources/semantic/dist/semantic.min.css">
		<script src="resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/new-topic.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/home.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/general.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/topics.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/new-topics.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script>
		<script src="resources/javascript/new-topic.js">
		</script>


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
	        				<li class="dropdown"><a href="#" id ="user-header" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Usuario <span class="caret"></span></a>
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
			<div class = "topics-column col-xs-12 col-sm-12 col-md-3 col-lg-3">



				<div id = "selected-topics">

					<ul class="nav nav-tabs">
						  <li><a href="#">Abiertos</a></li>
						  <li><a href="#">Cerrados</a></li>
					</ul>
				</div>



				<div class ="topics-list">
					<div class= "topic">
						<h4>Tema 1</h4>
						<h6>Cierra en 10 días</h6>

					</div>
					<div class= "topic">
						<h4>Tema 2</h4>
						<h6>Cierra en 10 días</h6>

					</div>
				</div>

			</div>

			<div class ="space-new-topic col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<form>
					<h3>Nuevo Tema</h3>
					<fieldset class="form-group">
				    	<label for="newTopic-inputName">Nombre del tema</label>
				    	<input type="text" class="form-control" id="topic-InputName" placeholder="Nombre del tema">
					</fieldset>


					<div class="form-group">
					  	<label for="sel1">Etiqueta:</label>
				  		<select class="form-control" id="sel1">
						    <option>Etiqueta1</option>
						    <option>Etiqueta2</option>
						    <option>Etiqueta3</option>
						    <option>Etiqueta4</option>
				  		</select>
					</div>

					<fieldset class="form-group">
						<label for="newTopic-inputAutor">Autor</label>
						<input type="text" class="form-control" id="newTopic-inputAutor" placeholder="Autor">
					</fieldset>


					<div>
						<label>Votable</label>
						<div class="onoffswitch">
						    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
						    <label class="onoffswitch-label" for="myonoffswitch">
						        <span class="onoffswitch-inner"></span>
						        <span class="onoffswitch-switch"></span>
						    </label>
						</div>
					</div>
					<div id='content'>Hello World</div>
					<input type='button' id='hideshow' value='hide/show'>

					<div class ="container-options-topic">
						<div class = "raw">	
							
							<div class="column">
								<h4>Modalidad de voto</h4>
							</div>

							<div class="column">
								<div class="checkbox">
							 		<label><input type="checkbox" value="">Privada</label>
								</div>
							</div>

							<div class="column">
								<div class="checkbox">
							 		<label><input type="checkbox" value="">Semipública</label>
								</div>
							</div>

						</div>

						<div class = "raw">	
							
							<div class="column">
								<h4>Tipo de votación</h4>
							</div>

							<div class="column">
								<div class="checkbox">
							 		<label><input type="checkbox" value="">Simple</label>
								</div>
							</div>

							<div class="column">
								<div class="checkbox">
							 		<label><input type="checkbox" value="">Selección</label>
								</div>
							</div>

							<div class="column">
								<div class="checkbox">
							 		<label><input type="checkbox" value="">Múltiple</label>
								</div>
							</div>
							
						</div>
						
					</div>
					<fieldset id=" question" class="form-group">
						<label for="">Escriba su pregunta</label>
						<input type="text" class="form-control" id="input-question" placeholder="Escriba su pregunta aquí">
					</fieldset>
											<label for="">Digite las opciones</label>

					<div class="fieldwrapper" id="field1">


   						<input id ="input-options"type="text" class="fieldname form-control">
    					<button type="button" class="remove btn btn-remove btn-danger" id="remove">
    							<span class="glyphicon glyphicon-minus"></span>

    					</button>

						<button type="button"  class="add btn btn-success btn-add " id="add">
							<span class="glyphicon glyphicon-plus"></span>
						</button>	
					</div>

				</form>
			</div>

		</div>

		


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>