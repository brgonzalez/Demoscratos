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
	</head>
	<body class="wall">
		<jsp:include page="includes/header.jsp" />
		<div class = "col-xs-12 col-sm-12 col-md-3 col-lg-3"> 
			<input onclick="location.href='/demoscratos/admin/forum/${idForum}/delete';" type="submit" class="btn btn-danger" value ="Borrar democracia"/>
		
		</div>
		
		<div class = "col-xs-12 col-sm-12 col-md-6 col-lg-6 " id= "container">
			<div>
				<div class ="topics-list">
					<ul style ="list-style:none">			
					<c:forEach var="topic" items="${topics}">
						<li>
							<a href="/demoscratos/admin/forum/${idForum}/topic/${topic.id}" method ="POST">
								<div class= "topic">
									<h4>${topic.title}</h4>
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