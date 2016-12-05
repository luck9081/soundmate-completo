<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="img/isologo.png">
  <link rel="icon" type="image/png" href="img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Registro - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
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
          <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <div class="card card-signup">
            
			           
              <form:form class="form" method="post" modelAttribute="usuario" action="registro">
                <div class="content">
                  <div style="margin-top:10px;" class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">face</i>
                    </span>
                    <form:input path="nombre" id="username" class="form-control" placeholder="Nombre de Usuario"></form:input>
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">email</i>
                    </span>
                    <form:input path="email" id="email" class="form-control" placeholder="Email"></form:input>
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">music_video</i>
                    </span>
                    <form:input path="instrumento" id="instrumento" class="form-control" placeholder="Instrumento"></form:input>
                  </div>
                  
                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">location_on</i>
                    </span>
                    <input type="text" id="ubicacion" class="form-control" placeholder="Ubicación"></input>
                    <form:hidden id="localidad" path="localidad"/>
                    <form:hidden id="partido" path="partido"/>
		            <form:hidden id="provincia" path="provincia"/>
                  </div>                  

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">lock_outline</i>
                    </span>
                    <form:password path="pass" id="pass" placeholder="Contraseña" class="form-control"></form:password>
                  </div>
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" name="optionsCheckboxes" checked />
                      Suscribirme al newsletter
                    </label>
                  </div>
                </div>
                <div class="footer text-center">
                	<button type="submit" class="btn btn-primary btn-round">
						Registrarme! <i class="material-icons">done</i>
					</button>
                </div>
                
                <div class="text-center">
                	<p class="text-divider">Ya tenés cuenta?
                		<a href="./login">Ingresá!</a>
                	</p>
                </div>

              </form:form>
              
              <br/>
              
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

<!-- MAPS  -->

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyByG25PdBB9LYQkjVm3MGcJKMem-CzZPPc&libraries=places"></script>
<script type="text/javascript" src="js/maps.js"></script>

</html>
