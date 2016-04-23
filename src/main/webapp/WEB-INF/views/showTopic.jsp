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
		
		<jsp:include page="includes/header.jsp" />


		<div class = "container">


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