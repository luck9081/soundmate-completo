<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
  <link rel="icon" type="image/png" href="img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

  <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/material-kit.css" rel="stylesheet"/>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>

  	<div class="wrapper">
    	<div class="header header-filter" style="background-image: url('img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
	      		
	          <div class="row">
	            <c:choose>
					<c:when test="${banda == null}">
						<div style="text-align:center" class="col-md-12"> 
							<h2>Al parecer aún no sos miembro de ninguna banda :(</h2>
							<h3>No pierdas más tiempo y armá la tuya acá!</h3> 
							<a href="crear-banda"> 
				                <button data-toggle="tooltip" data-placement="top" title="Agregar Banda" data-container="body" class="btn">
									<i class="material-icons">group_add</i> Crear Banda !
								</button>
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-6">
							<a href="banda/${banda.getNombre()}">
			               		<img data-toggle="tooltip" data-placement="right" title=" ir a banda" data-container="body" style="margin:10% 10% 0 0" src="img/default.gif" class="img-raised" />
			               	</a>
			               	<a href="banda/eliminar-user/${sessionScope.username}" style="margin:-15%; margin-top:-40%" data-toggle="tooltip" data-placement="top" title="Eliminarme de Banda" data-container="body" class="btn btn-fab btn-fab-mini btn-round">
								<i class="material-icons">delete</i>
							</a>
			                <h3 style="margin-left:5%">${banda.getNombre()}</h3>
			                
			            </div>
					</c:otherwise>
				</c:choose>					
	            
	          </div>
	         </div>
	       </div>
	    </div>
    </div>
    
	<%@ include file="../includes/pie.jsp" %>
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