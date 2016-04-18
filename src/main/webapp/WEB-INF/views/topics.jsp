<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="resources/semantic/dist/semantic.min.css">
		<script src="resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/topics.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/general.css">



		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">

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
	        				<li class="dropdown"><a href="" id ="user-header" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario <span class="caret"></span></a>
	          					<ul class="dropdown-menu">
						            <li><a href="/settings-profile">ConfiguraciÃ³n</a></li>
						            <li><a href="/login">Cerrar sesiÃ³n</a></li>

	          					</ul>
	        				</li>
	      				</ul>
	   				 </div><!-- /.navbar-collapse -->
	  			</div><!-- /.container-fluid -->
			</nav>
		</div>


		<div class = "container">


			<div class = "topics-column col-xs-12 col-sm-12 col-md-3 col-lg-3">



				<button id = "button-new"onclick="location.href='./new-topic.html'" type="" class="btn btn-primary" >Crear nuevo</button>


				<div id = "selected-topics">

					<ul class="nav nav-tabs">
						  <li><a href="#">Abiertos</a></li>
						  <li><a href="#">Cerrados</a></li>
					</ul>
				</div>


				<c:forEach var="topic" items="${topics}">
				
					<div class ="topics-list">
						<div class= "topic">
							<h4>${topic.title}</h4>
							<h6>${topic.closingAt}</h6>
	
						</div>
					</div>
				</c:forEach>	

			</div>

			<div class ="space-topic col-xs-12 col-sm-12 col-md-7 col-lg-7">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> Fecha de cierrre </h5>
					<h1 class ="name-topic">Nombre del tema</h2>
					<h4 class = "modality-topic">Modalidad: SemipÃºblico</h4>
					<h3 class = "tag-topic">Etiqueta</h4>
					<h4 class = "vote-topic">Voto</h5>
					<div class ="space-options-votes">
						<button type="" id = "btn-afirmative" class = "btn btn-options"> <span class = "glyphicon glyphicon-thumbs-up"></span> Afirmativo </button>
						<button type="" id = "btn-negative" class = "btn btn-options" ><span class = "glyphicon glyphicon-thumbs-down"></span> Negativo </button>
						<button type="" id = "btn-abstentionism" class = "btn btn-options"> <span class = "glyphicon glyphicon-pause"></span> AbstenciÃ³n</button>
					</div>

					<div class ="multi-vote">
						<h4 class = "description-multi-vote">Esta es la descripciÃ³n para multi</h5>

						<div class="checkbox">
						 	<label><input type="checkbox" value="">Option 1</label>
						</div>
						<div class="checkbox">
						 	<label><input type="checkbox" value="">Option 2</label>
						</div>
						<div class="checkbox disabled">
							<label><input type="checkbox" value="" >Option 3</label>
						</div>
							
					</div>

				
				

					<div class = "own-argument">
						<h4>Tus argumentos</h4>
						<textarea class="form-control" type="textbox" rows = "4" validate ="max-length:4096"></textarea>
					</div>

					<div class = "arguments">
						<h4>Argumentos</h4>
						<p>Un argumento</p>
						<p>Otro argumento argumento</p>

					</div>

				</div>





			</div>	
			


		</div>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>