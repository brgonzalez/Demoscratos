<%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
<html>

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/admin.css">
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

			<div id ="container-forums" class ="container-forums col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<ul>
					<li>
						<a href="admin/tags" method ="POST" class ="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								
							<div class = "admin" style ="background-color: #0B615E;">
	
								<h4>Etiquetas</h4>
									
								<hr>
									
								<p>Cada tema posee una etiqueta con la que hace referencia a..</p>
	
							</div>
						</a>
						<a href="admin/forums" method ="POST" class ="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								
							<div class = "admin" style ="background-color: #0B3B0B;">
	
								<h4>Gestión de democracias</h4>
									
								<hr>
									
								<p>En una democracia se puden crear un conjunto de temas relacionados</p>
	
							</div>
						</a>
						<!--  <a href="admin/topics" method ="POST" class ="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								
							<div class = "admin" >
	
								<h4>Gestión de temas</h4>
									
								<hr>
									
								<p>Cada tema creado por un usuario debe de ser aceptado por el administrador antes de ser publicado</p>
	
							</div>
						</a>
						<a href="admin/topics" method ="POST" class ="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								
							<div class = "admin" >
	
								<h4>Reportes</h4>
									
								<hr>
									
								<p>Se puede realizar un reporte de los temas para mejor visualización de resultados</p>
	
							</div>
						</a>-->
					</li>
				</ul>

				
			</div>
		

		</div>

		


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>