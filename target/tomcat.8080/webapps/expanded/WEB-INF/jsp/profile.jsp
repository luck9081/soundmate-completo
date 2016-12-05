<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="${reubicacion}img/apple-icon.png">
  <link rel="icon" type="image/png" href="${reubicacion}img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" type="text/css"/>

  <!-- CSS Files -->
  <link href="${reubicacion}css/bootstrap.min.css" rel="stylesheet"/>
  <link href="${reubicacion}css/material-kit.css" rel="stylesheet"/>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>

  	<div class="wrapper">
  		
    	<div class="header header-filter" style="background-image: url('${reubicacion}img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
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
        		
        		<div class="row" style="padding-bottom: 80px;">
                  <div class="col-md-12">
                  	<div class="col-md-3">
                  	
 						<div style="text-align:left; border:20pt; border-color:#f1f1f2">
                  			<h4>Infuencias</h4>
                  			<hr style="margin:0; padding:0;">
	                  		<p>${usuario.getInfluencias()}</p>
	                  	</div>                 	
                  		<div style="margin-top:58px;text-align:left; border:20pt; border-color:#f1f1f2">
                  			<h4>Informaci&oacute;n</h4>
                  			<hr style="margin:0; padding:0;">
	                  		<h6><i class="material-icons" style="font-size:18px;">email</i> ${usuario.getEmail()}</h6>
	                  		<h6><i class="material-icons" style="font-size:18px;">music_note</i> ${usuario.getInstrumento()}</h6>
	                  		<c:choose>
	                  			<c:when test="${usuario.getBanda() != null}">
			                  		<a href="${reubicacion}banda/${usuario.getBanda().getNombre()}">
			                  			<h6> <i class="material-icons" style="font-size:18px;">people</i> ${usuario.getBanda().getNombre()}</h6>
			                  		</a>
			                  	</c:when>	
	                  		</c:choose>
	                  	</div>
	                  	
	                  	<c:choose>
							
							<c:when test="${usuario.getNombre() == sessionScope.username}">
								<a href="perfil/editar" style="float:left" class="btn btn-primary btn-raised">Editar</a>
							</c:when>
							
							<c:otherwise>
						        
						        <c:choose>
									<c:when test="${mismaBanda == false}">
										<a href="sumarABanda/${usuario.getNombre()}" style="float:left" data-toggle="tooltip" data-placement="top" title="Agregar a banda" data-container="body" class="btn btn-primary btn-raised"><i class="material-icons">add</i>Agregar a Banda</a>
									</c:when>
								</c:choose>
								
						    </c:otherwise>
						    
						</c:choose>
	                  	
                  	</div>
                  	
                  	<div class="col-md-9">
		                  		
                  		<c:choose>
							<c:when test="${usuario.getNombre() == sessionScope.username}">
								
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
												<form:form modelAttribute="publicar" method="POST" action="post">
													<form:textarea path="descripcion" placeholder="Que tenes en mente?" class="form-control" rows="5"/>
													<form:button type="submit"  style="float:right" class="btn btn-primary btn-raised">Publicar</form:button>
												</form:form>
											</div>
											<div class="tab-pane" id="video">
												<form:form modelAttribute="publicar" method="POST" action="post">
													<form:input path="video" class="form-control" type="text" placeholder="Ingresa la URL del video"/>
													<form:button type="submit"  style="float:right" class="btn btn-primary btn-raised">Publicar</form:button>
												</form:form>
											</div>
										</div>
									</div>
								</div>
											
							</c:when>
						</c:choose>
               			
               			<h4>Publicaciones</h4>
                  		<hr style="margin:0; padding:0;">
                  		
                  		<!-- Aca arrancan las publicaciones de users -->
               			<div style="padding-top:2%" class="row">
               				
               				<c:forEach var="item" items="${publicaciones}">
								<div class="col-md-12" style="padding:1%; margin:1%; background-color:#f9f9f9;">
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
