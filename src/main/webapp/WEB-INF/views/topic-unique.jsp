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
	<body class="wall">
		<jsp:include page="includes/header.jsp" />

		<div class = "container">


			<div class ="space-topic col-xs-12 col-sm-12 col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${close}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: Semipúblico</h4>
					<button style="display:${isSecret};" onclick=" $('#vote-ring').show(); $('#button-show-ring').hide(); $('#button-hide-ring').show(); $('#${hasRing}').hide(); $('#btn-s-give-vote').show(); $('#btn-h-give-vote').hide(); " type="submit" id ="button-show-ring"class="btn btn-default">Votos de anillo</button>
					<button style="display:none;" onclick="$('#vote-ring').hide(); $('#button-hide-ring').hide(); $('#button-show-ring').show(); " type="submit" id ="button-hide-ring"class="btn btn-default">Ocultar votos de anillo</button>
					
					<button style="display:${isSecret};" onclick=" $('#btn-h-give-vote').show(); $(this).hide(); $('#vote-ring').hide(); $('#${hasRing}').show(); $('#button-show-ring').show(); $('#button-hide-ring').hide();" type="submit" id ="btn-s-give-vote" class="btn btn-default">Ceder voto</button>
					<button style="display:none;" onclick="$(this).hide(); $('#btn-s-give-vote').show(); $('#${hasRing}').hide();" type="submit" id ="btn-h-give-vote" class="btn btn-default">Ocultar ceder voto</button>
			
					<div style="display:none;" class="panel panel-default" id="vote-ring">
					  	<!-- Default panel contents -->
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
						<form:form action="/demoscratos/forum/${idForum}/topic/${idTopic}/unique" method="POST">
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
					<h4 class = "vote-topic">Voto personal</h4>
										
					<div style ="display: ${voted};"class="alert alert-info" role="alert" >
					  	<strong>Información!</strong> Ya has efectuado el voto o lo has cedido
					</div>
					
					<div style="display:${displayVote};" class="uniqueVote">
						<form:form action="/demoscratos/forum/${idForum}/topic/${idTopic}/unique">
							<h4 class = "description-multi-vote"> ${question} </h4>
							<div class="checkbox">
								<c:forEach var="option" items="${options}">
							 	<label class="form-control"><input class="unique" name="idOption" type="checkbox" value="${option.id}">${option.option} </label>
								</c:forEach>
							</div>
							
							<input type="submit" id="button-save" class="btn btn-primary button-save">
							
						</form:form>
					</div>	
					
					<div class ="givenVotes">
						<c:forEach var="vote" items="${givenVotes}">
							<HR>
							<div class="uniqueVote">
								
								<form:form action="/demoscratos/forum/${idForum}/topic/${idTopic}/unique/givenVote/${vote.id}">
									<h4>Voto cedido por ${vote.user.name} ${vote.user.lastName} </h4>
									<h4 class = "description-multi-vote"> ${question} </h4>
									<div class="checkbox">
										<c:forEach var="option" items="${options}">
									 	<label class="form-control"><input class="unique" name="idOption" type="checkbox" value="${option.id}">${option.option} </label>
										</c:forEach>
									</div>
								
									<button type="submit" id="button-save" class="btn btn-primary button-save">Votar</button>
									
								</form:form>
							</div>	
						
						</c:forEach>
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