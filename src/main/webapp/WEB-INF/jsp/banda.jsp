<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="${reubicacion}img/apple-icon.png">
  <link rel="icon" type="image/png" href="${reubicacion}img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil Banda - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" type="text/css"/>

  <!-- CSS Files -->
    <link href="${reubicacion}css/bootstrap.min.css" rel="stylesheet" />
    <link href="${reubicacion}css/material-kit.css" rel="stylesheet"/>
    
    <style>
    #publis:hover {
    	
    	background-color: #f2f2f2;
    	pointer:
    }
    </style>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>

  	<div class="wrapper">
    	<div class="header header-filter" style="background-image: url('${reubicacion}img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
	          <div class="row">
	          	  <!-- aca esta la info de perfil de la banda -->
	              <div class="profile">
	                  <div class="avatar">
	                      <img src="${reubicacion}img/default.gif" alt="Circle Image" class="img-circle img-responsive img-raised">
	                  </div>
	                  <div class="name">
	                    <h3 class="title">${banda.getNombre()}</h3>
	                    <h4><i class="material-icons" style="font-size:14px;">music_note</i>${banda.getGenero()}</h4>
	                  </div>
	        		</div>
	        		<!-- fin info de perfil de la banda -->
	        	</div>
        		<div class="row" style="min-height:600px">
        		  <!-- aca esta la info de la banda -->
                  <div class="col-md-12">
               		<div class="col-md-3">
                		<h4>Miembros:</h4>
               			<hr style="margin:0; padding:0;">
                		<c:forEach var="item" items="${miembros}">
                			<div style="float:left; padding-right:20px">
                				<a href="${reubicacion}perfil/${item.nombre}">
		                			<div><img src="<c:out value="${reubicacion}img/${item.imagen}"/>" class="img-circle img-responsive img-raised" style="width:50px" /></div>
		                			<h6><c:out value="${item.nombre}"/></h6>
	                			</a>
                			</div>
                		</c:forEach>
                		<c:choose>
               				<c:when test="${usuario.getBanda() != null}">
	               				<c:choose>
	               					<c:when test="${usuario.getBanda().getNombre() == banda.getNombre() }">
		               					<a href="eliminar-user/${sessionScope.username}" data-toggle="tooltip" data-placement="top" title="Eliminarme de Banda" data-container="body" class="btn btn-primary btn-raised">
										 	<i class="material-icons">delete</i>Eliminarme de Banda
									  	</a>
									 </c:when>
								</c:choose>
							</c:when>
							<c:otherwise>
							<div class="col-md-12" style="float:left; margin-left:-20px; margin-top:50px;"><a data-toggle="tooltip" data-placement="top" title="Agregarme a banda" data-container="body" class="btn btn-primary btn-raised" href="${banda.getNombre()}/agregarseABanda"><i class="material-icons">add</i>Agregarse a esta banda</a></div>
							</c:otherwise>
						</c:choose>
                  	</div>
                  	<!-- fin info de la banda -->
				  	<div class="col-md-9">
               			<c:choose>
							<c:when test="${sessionScope.username != null}">
							
							
               				<h4>Escribinos!</h4>
               				<hr style="margin:0; padding:0;">
	               			<!-- form para publicar comments en el muro -->
		
							<div class="card card-nav-tabs">
								<div class="header header-primary" style="height:auto">
									<div class="nav-tabs-navigation">
										<div class="nav-tabs-wrapper">
											<ul class="nav nav-tabs" data-tabs="tabs">
												<li class="active">
													<a href="#publicacion" data-toggle="tab">
														<i class="material-icons">chat</i>
														Publicacion
													</a>
												</li>
												<li>
													<a href="#video" data-toggle="tab">
														<i class="material-icons">videocam</i>
														Video
													</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="content">
									<div class="tab-content text-center">
										<div class="tab-pane active" id="publicacion">
											<form:form id="publicacion" modelAttribute="publicar" method="POST" action="../postear/${banda.getNombre()}">
						           				<form:textarea path="descripcion" class="form-control" placeholder="Escribi acá tu publicacion..." rows="5" />
						           				<form:button type="submit" style="float:right" class="btn btn-primary btn-raised">
						           					Publicar
						           				</form:button>
						           			</form:form>
										</div>
										<div class="tab-pane" id="video">
											<form:form modelAttribute="publicar" method="POST" action="../postear/${banda.getNombre()}">
												<form:input path="video" class="form-control" type="text" placeholder="Ingresa la URL del video"/>
												<form:button type="submit"  style="float:right" class="btn btn-primary btn-raised">Publicar</form:button>
											</form:form>
										</div>
									</div>
								</div>
							</div>	
							
							</c:when>
						</c:choose>
            	  	</div>
            	  </div>
               	  <div class="col-md-12">
           			<h4>Publicaciones:</h4>
               		<hr style="margin:0; padding:0;">
               		<!-- Aca arrancan las publicaciones de miembros y users -->
           			<div style="margin-right:1%" class="row">
   						<c:forEach var="item" items="${publicaciones}">
							<div class="col-md-12" style="padding:1%; margin:1%; background-color:#f9f9f9;" onmouseover="this.style.background="white">
								<div class="col-md-1">
	      								<img src="${reubicacion}img/<c:out value="${item.usuario.getImagen()}"/>" class="img-circle img-responsive">
								</div>
								<div class="col-md-11">
									<p>Publicado por <a href="${reubicacion}perfil/${item.usuario.getNombre()}"><span style="text-transform:uppercase"><c:out value="${item.usuario.getNombre()}"/></span></a> el <c:out value="${item.fechaPublicacion}"/></p>
									<c:choose>
										<c:when test="${item.descripcion == null}">
											<iframe type="text/html" width="640" height="360" src="https://www.youtube.com/embed/<c:out value="${item.video}"/>" frameborder="0" allowfullscreen></iframe>
										</c:when>
										<c:otherwise>
											<p><c:out value="${item.descripcion}"/></p>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:forEach>
               		 </div>
                   </div>
                  </div>
              	</div>
	          </div>
	         </div>
	       </div>
    
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

</html>
