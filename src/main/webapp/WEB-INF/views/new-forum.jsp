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
		
		<link href="/demoscratos/resources/bootstrap-datetimepicker-master/sample in bootstrap v3/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    	<link href="/demoscratos/resources/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script>

		
	</head>
	<body>
		<jsp:include page="includes/header.jsp" />

		<div class = "container">

			<div class ="space-new-topic col-xs-12 col-sm-12 col-md-8  col-lg-8 col-md-offset-2 col-lg-offset-2">
				<form:form href ="admin/forum/new" method ="POST">
					<h3>Crearción de una nueva democracia</h3>
					<fieldset class="form-group">
				    	<label>Nombre de ka democracia</label>
				    	<input type="text" class="form-control" name ="title" placeholder="Nombre de la democracia" required>
					</fieldset>


					<fieldset class="form-group">
						<label>Descripción</label>						
						<textarea name= "description" class="form-control" type="textbox" rows = "4" validate ="max-length:4096" required></textarea>
					</fieldset>
					
					<button onSubmit="alert('Operación existosa.');" type="submit" id="button-save" class="btn btn-primary button-save" >Guardar</button>
					
				</form:form>
			</div>

		</div>

		


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>