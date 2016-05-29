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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/tags.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body class="wall">
		<jsp:include page="includes/header.jsp" />
		<div class = "container col-xs-12 col-sm-12 col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3" id= "container">
				<h2> Reporte sobre el tema ${topic.title}. </h2>
				<hr>
				<h4> <b>La modalidad del tema es: </b> ${modality } </h4>
				<h4> <b>Total de participantes:</b> ${report.totalParticipants }</h4>
				<hr>
				<h4> Este tema ha dado como resultados</h4>
				
				<table class="table">
					<tr>
			  			<th>Opción</th>
			  			<th>Votos</th>
			  		</tr>
					<c:forEach var="vote" items="${report.totalVotes}">
	
						<tr>
							<th>${vote.option.option }</th>
							<th>${vote.total }</th>
						</tr>
				  	</c:forEach>
			  	</table>
		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>