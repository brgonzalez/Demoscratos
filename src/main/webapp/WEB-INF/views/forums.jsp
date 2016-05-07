<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/semantic/dist/semantic.min.css">
		<script src="/demoscratos/resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/forums.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/home.css">	
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">		
			
		
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script> 


	</head>

	<body>
		<jsp:include page="includes/header.jsp" />

		

		<div class = "container">

			<div class= "col-xs-1 col-sm-1 col-md-2 col-lg-3">
			</div>

			<div id ="container-forums" class ="container-forums col-xs-10 col-sm-10 col-md-8 col-lg-6">
				<ul>
					<c:forEach var="forum" items="${forums}">
						<li>
							<a action = "forum" href="forum/${forum.id}" method ="POST">
								
								<div class = "forum" key="${forum.id}">
	
									<h4>${forum.title}</h4>
									
									<hr>
									
									<p>${forum.summary}</p>
	
								</div>
							</a>
						</li>
					</c:forEach>	
				</ul>

				
			</div>
		
			<div class= "col-xs-1 col-sm-1 col-md-2 col-lg-3">
			</div>

		</div>

		


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>