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

	<body class ="wall">
		
		<jsp:include page="includes/header.jsp" />

		<div class = "container">

			<div class ="space-topic col-xs-12 col-sm-12 col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${close}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: ${modality}</h4>
					<div style="display:${isSecret};">
						
						<button style="display:${isSecret};" onclick=" $('#vote-ring').show(); $('#button-show-ring').hide(); $('#button-hide-ring').show(); $('#${hasRing}').hide(); $('#btn-s-give-vote').show(); $('#btn-h-give-vote').hide(); " type="submit" id ="button-show-ring"class="btn btn-default">Votos de anillo</button>
						<button style="display:none;" onclick="$('#vote-ring').hide(); $('#button-hide-ring').hide(); $('#button-show-ring').show(); " type="submit" id ="button-hide-ring"class="btn btn-default">Ocultar votos de anillo</button>
						
						<button style="display:${isSecret};" onclick=" $('#btn-h-give-vote').show(); $(this).hide(); $('#vote-ring').hide(); $('#${hasRing}').show(); $('#button-show-ring').show(); $('#button-hide-ring').hide();" type="submit" id ="btn-s-give-vote" class="btn btn-default">Ceder voto</button>
						<button style="display:none;" onclick="$(this).hide(); $('#btn-s-give-vote').show(); $('#${hasRing}').hide();" type="submit" id ="btn-h-give-vote" class="btn btn-default">Ocultar ceder voto</button>
						<div style="display:none;" class="panel panel-default" id="vote-ring">
						  	<table class="table table-striped">
							  		<tr>
							  			<td><b>Correo</b></td>
							  			<td><b>Nombre</b></td>
							  			<td><b>Voto</b></td>
							  		</tr>
						  		<c:forEach var="vote" items="${votes}">
								  		<tr>
								  			<td>${vote.user.email }</td>
								  			<td>${vote.user.name }</td>
								  			<td>${vote.option.option }</td>
								  			
								  		</tr>
							  	</c:forEach>
							  		
						  	</table>
						</div>
						<div style="display:none;" id ="selection-ring">
							<form:form action="/demoscratos/forum/${idForum}/topic/${idTopic}/simple" method="POST">
								<fieldset class="form-group">
								  	<label>Seleccione miembro del anillo de confianza</label>
							  		<select class="form-control" name = "memberRing">
								  		<c:forEach var="member" items="${members}">
										    <option>${member.email}</option>
								  		</c:forEach>
							  		</select>	  			
							</fieldset>
							<button type="submit" class="btn btn-default">Ceder</button>
							</form:form>
						</div>
						
						<div id ="no-ring" style ="display:none;"class="alert alert-info" role="alert" >
						  	<strong>Información!</strong> Usted no ha definido un anillo de confianza.
						</div>
						
						<div id ="voteGiven" style ="display:none;"class="alert alert-warning" role="alert" >
						  	<strong>Atención!</strong> No puedes ceder el voto, ya has efectuado o has cedido anteriormente
						</div>
										
					</div>
					<h3 class = "vote-topic">Voto personal</h3>
					
					<div style ="display: ${voted};"class="alert alert-info" role="alert" >
					  	<strong>Información!</strong> Ya has efectuado el voto o lo has cedido
					</div>
					
					<div style="display:${displayVote};" class ="space-options-votes">
						<form  action="/demoscratos/forum/${idForum}/topic/${idTopic}/simple" method="POST" >
							<button name="vote" value="positive" type="submit" id = "btn-afirmative"  class = "btn btn-options" > <span class = "glyphicon glyphicon-thumbs-up"></span> Afirmativo </button>
							<button name="vote" value="negative" type="submit" id = "btn-negative" class = "btn btn-options" ><span class = "glyphicon glyphicon-thumbs-down"></span> Negativo </button>
							<button name="vote" value="abstentionism" type="submit" id = "btn-abstentionism" class = "btn btn-options"> <span class = "glyphicon glyphicon-pause"></span> Abstención</button>
						</form>
					</div>
					
					<div>
						<c:forEach var="vote" items="${givenVotes}">
						<hr>
						<h4 style= "color:#8A0886;" class = "vote-topic"> Voto cedido por ${vote.user.name} ${vote.user.lastName} </h4>
						<div  class ="space-options-votes">
							<form  action="/demoscratos/forum/${idForum}/topic/${idTopic}/simple/${vote.id}" method="POST" >
								<button name="idOption" value="1" type="submit" id = "btn-afirmative"  class = "btn btn-options" > <span class = "glyphicon glyphicon-thumbs-up"></span> Afirmativo </button>
								<button name="idOption" value="2" type="submit" id = "btn-negative" class = "btn btn-options" ><span class = "glyphicon glyphicon-thumbs-down"></span> Negativo </button>
								<button name="idOption" value="3" type="submit" id = "btn-abstentionism" class = "btn btn-options"> <span class = "glyphicon glyphicon-pause"></span> Abstención</button>
							</form>
						</div>
							
						</c:forEach>
					
					</div>
					
					
					<div style="display: given-votes;">
					
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