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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/new-topic.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/home.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/topics.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/new-topic.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script>
		<script src="/demoscratos/resources/javascript/new-topic.js"></script>

		
	</head>
	<body class="wall">
		<jsp:include page="includes/header.jsp" />

		<div class = "container">

			<div class ="space-new-topic col-xs-12 col-sm-12 col-md-8  col-lg-8 col-md-offset-2 col-lg-offset-2">
				<div style ="display: ${errorDate};"class="alert alert-danger" role="alert" >
				  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  	<strong>Error!</strong> La fecha de cierre debe ser mayor a la actual.
				</div>
				
				<div style ="display: ${successNewTopic};"class="alert alert-success" role="alert" >
				  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  	<strong>Éxito!</strong> Se ha creado el tema, se debe esperar la aprobación de un administrador.
				</div>
				<form:form href ="forum/${idForum}/topic/new" method ="POST">
					<h3>Nuevo Tema</h3>
					<fieldset class="form-group">
				    	<label>Nombre del tema</label>
				    	<input type="text" class="form-control" name ="title" placeholder="Nombre del tema" required>
					</fieldset>


					<div class="form-group">
					  	<label>Etiqueta:</label>
				  		<select class="form-control" id="sel1" name = "tag">
					  		<c:forEach var="tag" items="${tags}">
							    <option>${tag.name}</option>
					  		</c:forEach>
				  		</select>	  			
					</div>

					<fieldset class="form-group">
						<label>Contenido</label>						
						<textarea name= "content" class="form-control" type="textbox" rows = "4" validate ="max-length:4096" required></textarea>
					</fieldset>
					
					<fieldset style ="display: none;" class="form-group">
				    	<label>URL del tema</label>
				    	<input type="text" class="form-control" name ="source" placeholder="Url del tema" value="http://democracyos.org/">
					</fieldset>
					<fieldset>
			            <div class="form-group">
			                <label>Fecha de cierre</label>
			                <div class="input-group date form_datetime col-md-5" data-date="2016-06-16T05:25:07Z" data-date-format="dd MM yyyy- HH:ii p" data-link-field="dtp_input1">
			                    <input class="form-control" size="16" type="text" value="" required>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
			                </div>
							<input type="hidden" name="closingAt" id="dtp_input1" value="" required/><br/>
			            </div>
			
        			</fieldset>

					<fieldset class="form-group">

						<div>
							<label>Votable</label>
							<div class="onoffswitch">
							    <input type="checkbox" name="votable" class="onoffswitch-checkbox" id="xxx" checked value="true">
							    <label class="onoffswitch-label" for="xxx">
							        <span class="onoffswitch-inner"></span>
							        <span class="onoffswitch-switch"></span>
							    </label>
							</div>
						</div>
	
	
						<div id = "settings-vote" class ="container-options-topic form-group" >
							<div class = "raw">	
								<div class="column">
									<h4>Modalidad de voto</h4>
								</div>
								<div class="column">
									<div class="checkbox">
								 		<label><input name="secret" id="secret" type="checkbox" checked value="true">Privada</label>
									</div>
								</div>
								<div class="column">
									<div class="checkbox">
								 		<label><input name ="semiPublic" id ="semiPublic" type="checkbox" value="false"/>Semipública</label>
									</div>
								</div>
							</div>
							<div class = "raw">			
								<div class="column">
									<h4>Tipo de votación</h4>
								</div>
								<div class="column">
									<div class="checkbox">
								 		<label><input name ="simple" id="simple" type="checkbox" checked value="true">Simple</label>
									</div>
								</div>
								<div class="column">
									<div class="checkbox">
								 		<label><input name ="selection" id ="selection" type="checkbox" value="false">Selección</label>
									</div>
								</div>
								<div class="column">
									<div class="checkbox">
								 		<label><input name ="multiselection" id="multiselection"type="checkbox" value="false">Múltiple</label>
									</div>
								</div>
							</div>
						</div>
						
						<div style= "display: none;"id ="space-selections">
							<label >Escriba su pregunta</label>
							<input type="text" name = "question" class="form-control" id="input-question" placeholder="Escriba su pregunta">
		
							
							<label>Ingrese las opciones</label>
		
							<div class="input_fields_wrap" id="short-input">
							
					            <div><input  type="text" name="optionsQuestion[]" class="form-control" value=""><span id="icon" class="add_field_button glyphicon glyphicon-plus-sign"></span></div>

					        </div>
				        
				        </div>
			        </fieldset>
					
					
			       
			        <button onSubmit="alert('Operación existosa.');" type="submit" id="button-save" class="btn btn-primary button-save" >Guardar</button>
			         
			        <script type="text/javascript" src="/demoscratos/resources/bootstrap-datetimepicker-master/sample in bootstrap v3/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
					<!-- <script type="text/javascript" src="/demoscratos/resources/bootstrap-datetimepicker-master/sample in bootstrap v3/bootstrap/js/bootstrap.min.js"></script> -->
					<script type="text/javascript" src="/demoscratos/resources/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
					<script type="text/javascript" src="/demoscratos/resources/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
					<script type="text/javascript">
					    $('.form_datetime').datetimepicker({
					        //language:  'fr',
					        weekStart: 1,
					        todayBtn:  1,
							autoclose: 1,
							todayHighlight: 1,
							startView: 2,
							forceParse: 0,
					        showMeridian: 1
					    });
						$('.form_date').datetimepicker({
					        language:  'fr',
					        weekStart: 1,
					        todayBtn:  1,
							autoclose: 1,
							todayHighlight: 1,
							startView: 2,
							minView: 2,
							forceParse: 0
					    });
						$('.form_time').datetimepicker({
					        language:  'fr',
					        weekStart: 1,
					        todayBtn:  1,
							autoclose: 1,
							todayHighlight: 1,
							startView: 1,
							minView: 0,
							maxView: 1,
							forceParse: 0
					    });
					</script>
			       

				</form:form>
			</div>

		</div>

		


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="/demoscratos/resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>