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
		<link rel="stylesheet" type="text/css" href="/demoscratos/resources/styles/home.css">	
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
		
			<div style ="display: ${errorLogin};"class="alert alert-danger col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" role="alert" >
			  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  	<strong>Error!</strong> El correo o la contraseña están incorrectas.
			</div>

            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" >
                    <div class="panel-heading" id="panel-login-register">
                        <div class="panel-title">Ingresar</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="">Olvido su contraseña?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                                
                        <form:form id="loginform" class="form-horizontal" action="login" href="" method="post">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="email" value="" placeholder="Correo" required>                                        
                            </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder="Contraseña" required>
                            </div>
                                    

                                
                            <div class="input-group">
                                      <!--  <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Recordar
                                        </label>
                                      </div> -->
                            </div>


                            <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <input href="/demoscratos/forums" type ="submit" id="btn-login" class="btn btn-success" value="Ingresar"  />
                                      <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>-->

                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                        No tiene una cuenta! 
                                    <a href="signup">
                                        Registrarse aquí­
                                    </a>
                                    </div>
                                </div>
                            </div>    
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