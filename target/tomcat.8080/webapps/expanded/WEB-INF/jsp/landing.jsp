<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${reubicacion}img/apple-icon.png">
	<link rel="icon" type="image/png" href="${reubicacion}img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>${title} - Soundmate</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="${reubicacion}css/bootstrap.min.css" rel="stylesheet" />
    <link href="${reubicacion}css/material-kit.css" rel="stylesheet"/>

</head>

<body class="landing-page">
    <%@ include file="../includes/menu.jsp" %>

    <div class="wrapper">
        <div class="header header-filter" style="background-image: url('${reubicacion}img/bg-concert.jpg');">
            <div class="container">
                <div class="row">
					<div class="col-md-6">
						<h1 class="title">${titulo}</h1>
	                    <h4>${subtitulo}</h4>
	                    <br />
	                    <a href="${inputHref}" class="btn btn-raised btn-lg">
							<i class="${iconClass}" aria-hidden="true"></i> ${inputValue}
						</a>
					</div>
                </div>
            </div>
        
       		<%@ include file="../includes/pie.jsp" %>

		</div>
	</div>
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
