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
			<div class = "topics-column col-xs-12 col-sm-12 col-md-6 col-lg-6">
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
			</div>	
		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>