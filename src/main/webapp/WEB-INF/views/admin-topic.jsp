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

	<body class="wall">
		
		<jsp:include page="includes/header.jsp"/>

		<div class ="container col-xs-12 col-sm-12 col-md-12 col-lg-12">
		
			<div class= "buttons-topic col-xs-6 col-sm-6 col-md-2 col-lg-2">
				<form:form href="admin/forum/${idForum}/topic/${idTopic}/publish">
					<button class ="btn btn-default form-control" type="submit">Publicar tema</button>
				</form:form>
				<form:form action="/demoscratos/admin/forum/${idForum}/topic/${idTopic}/report" method="POST">
					<button class ="btn btn-default form-control" type="submit">Reporte de tema </button>
				</form:form>
				<form:form href="admin/forum/${idForum}/topic/${idTopic}/delete">
					<button class ="btn btn-default form-control" type="submit">Borrar tema </button>
				</form:form>
			</div>

			<div class ="space-topic view-topic col-xs-6 col-sm-6 col-md-8 col-lg-8">

				<div class ="header-topic">
				
					<h5><span class = "glyphicon glyphicon-time"></span> ${topic.closingAt}</h5>
					<h1 class ="name-topic">${topic.title}</h1>
					<h4 class = "modality-topic">Modalidad: ${modality}</h4>
				</div>
				
				<div style="display:${simple};">
					<h4>Votación Simple</h4>
				</div>
				<div style="display:${noSimple};">
					<h4>Pregunta: ${topic.question} </h4>
					<c:forEach var="option" items="${topic.options}">
						<label class="form-control"> ${option.option}</label>
					</c:forEach>
				</div>

			</div>	

		</div>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>