<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="${reubicacion}img/apple-icon.png">
  <link rel="icon" type="image/png" href="${reubicacion}img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Editar Perfil - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

  <!-- CSS Files -->
    <link href="${reubicacion}css/bootstrap.min.css" rel="stylesheet" />
    <link href="${reubicacion}css/material-kit.css" rel="stylesheet"/>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>
	<form:form class="form" id="form" method="POST" action="${reubicacion}editarPerfil" modelAttribute="usuario">
  	<div class="wrapper">
  	
    	<div class="header header-filter" style="background-image: url('${reubicacion}img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div style="padding-bottom:30px;" class="container">
	          <div class="row">
	          
	          	<div class="profile">
					<div class="avatar">
						<img src="${reubicacion}img/${usuario.getImagen()}" alt="Circle Image" class="img-circle img-responsive img-raised">
					</div>
					<div class="name">
						<h3 class="title">${usuario.getNombre().toUpperCase()}</h3>
	                    <h6><i class="material-icons" style="font-size:14px;">location_on</i> ${usuario.getLocalidad()}, ${usuario.getPartido()}, ${usuario.getProvincia()}</h6>
					</div>
				</div>
	          
	          </div>
        		
        		<div class="row">
                  <div class="col-md-12">
                  	
                  	<div class="col-md-3">
                  		<div style="text-align:left; border:20pt; border-color:#f1f1f2">
                  			
                  			<h4>Editar Informaci&oacute;n de Perfil</h4>
                  			<hr style="margin:0; padding:0;">
                  			
                  			<div class="input-group">
			                    <span class="input-group-addon">
			                      <i class="material-icons" style="font-size:25px;">face</i>
			                    </span>
	                  			<form:input path="nombre" class="form-control" value="${usuario.getNombre().toUpperCase()}" />
	                  		</div>
	                  		
	                  		<div class="input-group">
			                    <span class="input-group-addon">
			                      <i class="material-icons" style="font-size:25px;">lock</i>
			                    </span>
	                  			<form:password path="pass" class="form-control" value="${usuario.getPass()}" />
	                  		</div>
                  			
                  			<div class="input-group">
			                    <span class="input-group-addon">
			                      <i class="material-icons" style="font-size:25px;">location_on</i>
			                    </span>
	                  			<input type="text" id="ubicacion" class="form-control" placeholder="Ubicación"></input>
	                  			<form:hidden id="localidad" path="localidad" value="${usuario.getLocalidad()}"/>
			                    <form:hidden id="partido" path="partido" value="${usuario.getPartido()}"/>
					            <form:hidden id="provincia" path="provincia" value="${usuario.getProvincia()}"/>
	                  		</div>
                  			
                  			<div class="input-group">
			                    <span class="input-group-addon">
			                      <i class="material-icons" style="font-size:25px;">email</i>
			                    </span>
	                  			<form:input path="email" class="form-control" value="${usuario.getEmail()}" />
	                  		</div>
	                  		
	                  		<div class="input-group">
			                    <span class="input-group-addon">
			                      <i class="material-icons" style="font-size:25px;">music_note</i>
			                    </span>
	                  			<form:input path="instrumento" class="form-control" value="${usuario.getInstrumento().toUpperCase()}" />
	                  		</div>	                  		
	                  	</div>
                  	</div>
                  	
                  	<div class="col-md-9">
                  		<h4>Editar Influencias</h4>
                  		<hr style="margin:0; padding:0;">
                  		
                       	<div class="input-group">
		                    <span class="input-group-addon">
		                      <i class="material-icons" style="font-size:25px;">music_note</i>
		                    </span>
		                    <form:textarea path="influencias" row="3" class="form-control" placeholder="Artistas y géneros que te influencian" value="${usuario.getInfluencias()}"/>
		                </div>
		                
		                <button style="float:right" type="submit" class="btn btn-primary">
							<i class="material-icons">done</i> Confirmar!
						</button>
                  	</div>
                  	
                  </div>
              	</div>
				
	          </div>
	        </div>
	      </div>
    	</div>
   	</form:form>
	<%@ include file="../includes/pie.jsp" %>
</body>
  <!--   Core JS Files   -->
  <script src="${reubicacion}js/jquery.min.js" type="text/javascript"></script>
  <script src="${reubicacion}js/bootstrap.min.js" type="text/javascript"></script>
  <script src="${reubicacion}js/material.min.js"></script>

  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="${reubicacion}js/nouislider.min.js" type="text/javascript"></script>

  <!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
  <script src="${reubicacion}js/bootstrap-datepicker.js" type="text/javascript"></script>

  <!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
  <script src="${reubicacion}js/material-kit.js" type="text/javascript"></script>
  
	<!-- MAPS  -->
	
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyByG25PdBB9LYQkjVm3MGcJKMem-CzZPPc&libraries=places"></script>
	<script type="text/javascript" src="${reubicacion}js/maps.js"></script>

</html>
