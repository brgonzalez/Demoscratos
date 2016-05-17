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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/topics.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">
		
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script>
        
        <script src="/demoscratos/resources/javascript/simpleTopic.js"></script>
        
	</head>

	<body>
		
		<jsp:include page="includes/header.jsp" />

		<div class = "container">

			<div class ="space-topic col-xs-12 col-sm-12 col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${topic.closingAt}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: ${modality}</h4>
					<h3 class = "tag-topic">Etiqueta</h3>
					
					<button style="display:${isSecret};" onclick=" $('#vote-ring').show(); $('#button-show-ring').hide(); $('#button-hide-ring').show();" type="submit" id ="button-show-ring"class="btn btn-default">Mostrar votos de anillo</button>
					<button style="display:none;" onclick="$('#vote-ring').hide(); $('#button-hide-ring').hide(); $('#button-show-ring').show(); " type="submit" id ="button-hide-ring"class="btn btn-default">Ocultar votos de anillo</button>
					
					<div style="display:none;" class="panel panel-default" id="vote-ring">
					  	<!-- Default panel contents -->
					  	<div class="panel-heading">Votos de anillos de confianza</div>

					
					  	<table class="table">
					  		<tr>
					  			<th>Correo</th>
					  			<th>Voto</th>
					  		</tr>
					  		<c:forEach var="vote" items="${votes}">
					  		
						  		<tr>
						  			<th>${vote.email }</th>
						  			<th>${vote.stringOption }</th>
						  		</tr>
						  	</c:forEach>
						  		
					  	</table>
					</div>
					<h4 class = "vote-topic">Voto</h4>
					<h3 class = "voted" style="display:${voted};"> Usted ya efectuó el voto en este tema</h3>
					<div style="display:${displayVote};" class ="space-options-votes">
						<form  action="/demoscratos/forum/${idForum}/topic/${idTopic}/simple" method="POST" >
							<button name="vote" value="positive" type="submit" id = "btn-afirmative"  class = "btn btn-options" > <span class = "glyphicon glyphicon-thumbs-up"></span> Afirmativo </button>
							<button name="vote" value="negative" type="submit" id = "btn-negative" class = "btn btn-options" ><span class = "glyphicon glyphicon-thumbs-down"></span> Negativo </button>
							<button name="vote" value="abstentionism" type="submit" id = "btn-abstentionism" class = "btn btn-options"> <span class = "glyphicon glyphicon-pause"></span> Abstención</button>
						</form>
					</div>
					<!-- 
					<div class = "own-argument">
						<h4>Tus argumentos</h4>
						<textarea class="form-control" type="textbox" rows = "4" validate ="max-length:4096"></textarea>
					</div>

					<div class = "arguments">
						<h4>Argumentos</h4>
						<p>Un argumento</p>
						<p>Otro argumento argumento</p>

					</div>
					
					 -->

				</div>





			</div>	
			


		</div>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>