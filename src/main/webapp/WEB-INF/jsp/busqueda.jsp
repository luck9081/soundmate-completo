<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
	<head>
	  <meta charset="utf-8" />
	  <link rel="apple-touch-icon" sizes="76x76" href="img/isologo.png">
	  <link rel="icon" type="image/png" href="img/favicon.png">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	  <title>SoundMate - Búsqueda</title>
	
	  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
	
	  <!-- Fonts and icons -->
		  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
		  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
	
	  <!-- CSS Files -->
		  <link href="css/bootstrap.min.css" rel="stylesheet" />
		  <link href="css/material-kit.css" rel="stylesheet"/>
	
	</head>
	
	<body class="signup-page">
		<%@ include file="../includes/menu.jsp" %>
	  	<div class="wrapper">
	    	<div class="header header-filter" style="background-image: url('img/bg-concert.jpg'); background-size: cover; background-position: top center;">
		      <div class="container">
		        <div class="row">
		          <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
		            <div class="card card-signup">
		            
		              <form:form modelAttribute="busqueda" class="form" method="post" action="resultadoBusqueda">
		                <div class="content">
		                  
		                  <div class="text-center">
		                	<h2>¡Buscá nuevos compañeros!</h2>
		                	<br/>
		                	<h5>En tus cercanías hay SoundMates que te están esperando</h5>
		                  </div>
		                  
		                  <div class="input-group">
		                    <span class="input-group-addon">
		                      <i class="material-icons">face</i>
		                    </span>
							<form:input id="instrumento" path="instrumento" class="form-control" placeholder="Instrumento" />
							<form:hidden id="localidad" path="localidad" value="${sessionScope.localidad}"/>
		                    <form:hidden id="partido" path="partido" value="${sessionScope.partido}"/>
		                    <form:hidden id="provincia" path="provincia" value="${sessionScope.provincia}"/>
		                  </div>
		                  
		                </div>
		                
		                <div class="footer text-center">
		                	<button type="submit" class="btn btn-info btn-round">
								Buscar SoundMates!  <i class="material-icons">skip_next</i>
							</button>
		                </div>
		                
		              </form:form>
		              
		            </div>
		          </div>
		        </div>
		      </div>
		      <%@ include file="../includes/pie.jsp" %>
	    	</div>
	  	</div>
	</body>

	<!--   Core JS Files   -->
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/material.min.js"></script>
	
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
		<script src="js/nouislider.min.js" type="text/javascript"></script>
	
	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
		<script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
	
	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
		<script src="js/material-kit.js" type="text/javascript"></script>

</html>