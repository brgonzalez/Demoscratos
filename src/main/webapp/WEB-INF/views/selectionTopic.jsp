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
	</head>
	<body>
		<jsp:include page="includes/header.jsp" />

		<div class = "container">


			<div class ="space-topic col-xs-12 col-sm-12 col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">

				<div class ="view-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${topic.closingAt}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: Semipúblico</h4>
					<h3 class = "tag-topic">Etiqueta</h4>
					<h4 class = "vote-topic">Voto</h4>
					<div class ="space-options-votes">
						<button action ="votePositive" type="submit" id = "btn-afirmative" class = "btn btn-options"> <span class = "glyphicon glyphicon-thumbs-up"></span> Afirmativo </button>
						<button type="submit" id = "btn-negative" class = "btn btn-options" ><span class = "glyphicon glyphicon-thumbs-down"></span> Negativo </button>
						<button type="submit" id = "btn-abstentionism" class = "btn btn-options"> <span class = "glyphicon glyphicon-pause"></span> Abstención</button>
					</div>	|
					
					<div class ="multi-vote">
						<form:form>
							<h4 class = "description-multi-vote"> ${question} </h4>
							
							<c:forEach var="option" items="${options}">
								<h5> ${option} </h5>
							</c:forEach>
	
							<div class="checkbox">
							 	<label><input type="checkbox" value="">Option 1</label>
							</div>
							<div class="checkbox">
							 	<label><input type="checkbox" value="">Option 2</label>
							</div>
							<div class="checkbox disabled">
								<label><input type="checkbox" value="" >Option 3</label>
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