<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

	<head>
		<title>Demoscratos</title>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="resources/semantic/dist/semantic.min.css">
		<script src="resources/semantic/dist/semantic.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="resources/styles/login.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/header.css">
		<link rel="stylesheet" type="text/css" href="resources/styles/home.css">	
		<link rel="stylesheet" type="text/css" href="resources/styles/general.css">	

		<link rel="stylesheet" type="text/css" href="styles/general.css">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
        <script type="text/javascript"></script> 


		<script src="resources/javascript/login.js"></script>

	</head>

	<body>
		<div class = "header">
			<nav  id = "header"class="navbar navbar-default">
  				<div class="container-fluid">
    			<!-- Brand and toggle get grouped for better mobile display -->
    				<div class="navbar-header">
      					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
      					</button>
      					<a href="/home" id="name-app"class="navbar-brand">Demoscratos</a>
   					</div>

    <!-- Collect the nav links, forms, and other content for toggling -->
	    			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      				<ul class="nav navbar-nav">
					    </ul>
	      
	      				<ul class="nav navbar-nav navbar-right">
	        				<li class="dropdown"><a href="#" id ="user-header" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario <span class="caret"></span></a>
	          					<ul class="dropdown-menu">
						            <li><a href="/settings-profile">Configuración</a></li>
						            <li><a href="/login">Cerrar sesión</a></li>

	          					</ul>
	        				</li>
	      				</ul>
	   				 </div><!-- /.navbar-collapse -->
	  			</div><!-- /.container-fluid -->
			</nav>
		</div>

		

		<div class="container">

			    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading" id="panel-login-register">
                        <div class="panel-title">Ingresar</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Olvido su contraseÃ±a?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form:form id="loginform" class="form-horizontal" action="login" method="post">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="email" value="" placeholder="Correo">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="Contraseña">
                                    </div>
                                    

                                
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Recordar
                                        </label>
                                      </div>
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <input type ="submit" id="btn-login" class="btn btn-success" value="Ingresar"  />
                                      <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>-->

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            No tine una cuenta! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Registrarse aquí­
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form:form>     



                        </div>                     
                    </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Registrarse</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Ingresar</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                
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
                                        <input type="text" class="form-control" name="firstname" placeholder="Nombre">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Apellido</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Apellido">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">ContraseÃ±a</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="passwd" placeholder="ContraseÃ±a">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="icode" placeholder="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                <!--
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                    </div>                                           
                                        
                                </div>

                            -->
                                
                                
                                
                            </form>
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