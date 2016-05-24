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
        <script src="/demoscratos/resources/javascript/uniqueTopic.js"> </script>
        
	</head>
	<body>
		<jsp:include page="includes/header.jsp" />

		<div class = "container">


			<div class ="space-topic col-xs-12 col-sm-12 col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${close}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: Semipúblico</h4>
					<h3 class = "tag-topic">Etiqueta</h3>
					<h4 class = "vote-topic">Voto</h4>
					
					<button style="display:${isSecret};" onclick=" $('#vote-ring').show(); $('#button-show-ring').hide(); $('#button-hide-ring').show();" type="submit" id ="button-show-ring"class="btn btn-default">Mostrar votos de anillo</button>
					<button style="display:none;" onclick="$('#vote-ring').hide(); $('#button-hide-ring').hide(); $('#button-show-ring').show(); " type="submit" id ="button-hide-ring"class="btn btn-default">Ocultar votos de anillo</button>
					
					<div style="display:none;" class="panel panel-default" id="vote-ring">
					  	<!-- Default panel contents -->
					  	<div class="panel-heading">Votos de anillos de confianza</div>

					
					  	<table class="table">
					  		<tr>
					  			<th>Correo</th>
					  			<th>Nombre</th>
					  			<th>Voto</th>
					  		</tr>
					  		<c:forEach var="vote" items="${votes}">
					  		
						  		<tr>
						  			<th>${vote.user.email }</th>
						  			<th>${vote.user.name }</th>
						  			<th>${vote.option.option }</th>
						  			
						  		</tr>
						  	</c:forEach>
						  		
					  	</table>
					</div>
					<h3 class = "voted" style="display:${voted};"> ${message} </h3>
					
					<div style="display:${displayVote};" class="uniqueVote">
						<form:form href="/demoscratos/forum/${idForum}/topic/${idTopic}/unique">
							<h4 class = "description-multi-vote"> ${question} </h4>
							<div class="checkbox">
								<c:forEach var="option" items="${options}">
							 	<label class="form-control"><input class="unique" name="idOption" type="checkbox" value="${option.id}">${option.option} </label>
								</c:forEach>
							</div>
							
							<input type="submit" id="button-save" class="btn btn-primary button-save">
							
						</form:form>
					</div>			


				</div>





			</div>	
			


		</div>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>