<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">
		
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/login.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/general.css">	


		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/demoscratos/resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script> 


		<script src="/demoscratos/resources/javascript/login.js"></script>

	</head>

	<body class="wall">
		
		<jsp:include page="includes/header.jsp" />
		

		<div class="container">

            <div id="signupbox" style="display:block; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                    <div class="panel-title">Registrarse</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="login">Ingresar</a></div>
                    </div>  
                    <div class="panel-body" >
                        <form:form id="loginform" class="form-horizontal" action="signup" href="" method="post">
                            
                            <div id="signupalert" style="display:none" class="alert alert-danger">
                                <p>Error:</p>
                                <span></span>
                            </div>
                                
                            
                              
                            <div class="form-group">
                                <label for="email" class="col-md-3 control-label">Correo</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="email" placeholder="Correo">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label for="firstname" class="col-md-3 control-label">Nombre</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="firstName" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-md-3 control-label">Apellido</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="lastName" placeholder="Apellido">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Contraseña</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" placeholder="Contraseña">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label for="icode" class="col-md-3 control-label">Repita Contraseña</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="rePasswd" placeholder="Contraseña">
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Button -->                                        
                                <div class="col-md-offset-3 col-md-9">
                                    <input href="/demoscratos/forums" type ="submit" id="btn-login" class="btn btn-success" value="Registrarse"  />
                                </div>
                            </div>
                            <!--
                            <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                </div>                                           
                                    
                            </div>

                        -->                       
                        </form:form>
                     </div>
                </div>
            </div>    	
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="resources/js/bootstrap.min.js"></script>
			
 	</body>

</html>