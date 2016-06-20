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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
        <script type="text/javascript"></script>
		<script src="/demoscratos/resources/javascript/general.js"></script>
		<script src="/demoscratos/resources/javascript/bootbox.min.js"></script>
		
		


	</head>
	<body class="wall">
		<jsp:include page="includes/header.jsp" />
		<div class = "col-xs-12 col-sm-12 col-md-3 col-lg-3"> 
			<form:form  action="/demoscratos/admin/forum/${idForum}/delete/${forum.name}" method="POST">
				<button type="submit" onclick="return confirm('¿Está seguro que desea borrar está democracia?');" class="btn btn-danger btn-block">Borrar democracia</button>
			</form:form>
		</div>
		
		<div class = "col-xs-12 col-sm-12 col-md-6 col-lg-6 " id= "container">
			<div>
				<div class ="container-forums">
					<ul style ="list-style:none">			
					<c:forEach var="topic" items="${topics}">
						<li>
							<a href="/demoscratos/admin/forum/${idForum}/topic/${topic.id}" method ="POST">
								<div class= "forum-topic black">
									<h4>${topic.title}</h4>
									<hr>
									<h6>${topic.closingAt}</h6>
								</div>
							</a>
						</li>
					</c:forEach>
					</ul>
					
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