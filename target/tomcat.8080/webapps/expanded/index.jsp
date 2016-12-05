<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../img/apple-icon.png">
	<link rel="icon" type="image/png" href="../img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Soundmate</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/material-kit.css" rel="stylesheet"/>

</head>

<body class="landing-page">
    <%@ include file="WEB-INF/includes/menu.jsp" %>

    <div class="wrapper">
        <div class="header header-filter" style="background-image: url('img/bg-concert.jpg');">
            <div class="container">
                <div class="row">
					<div class="col-md-6">
						<h1 class="title">¡Bienvenidx!</h1>
	                    <h3>¿Aún no sos uno de nosotros?</h3>
	                    <h4>Hacé click en el link de abajo y comenzá a disfrutar del increíble mundo de Soundmate :)</h4>
	                    <br />
	                    <a href="signup" class="btn btn-raised btn-lg">
							<i class="fa fa-play"></i> Comenzar
						</a>
					</div>
                </div>
            </div>
        
       		<%@ include file="WEB-INF/includes/pie.jsp" %>

		</div>
	</div>
</body>

	<!--   Core JS Files   -->
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/material.min.js"></script>


	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
	<script src="js/material-kit.js" type="text/javascript"></script>

</html>
