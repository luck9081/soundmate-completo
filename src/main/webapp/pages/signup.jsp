<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../img/isologo.png">
  <link rel="icon" type="image/png" href="../img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Sign Up Page - Material Kit by Creative Tim</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

  <!-- CSS Files -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <link href="../css/material-kit.css" rel="stylesheet"/>

</head>

<body class="signup-page">
 <nav class="navbar navbar-transparent navbar-fixed-top navbar-color-on-scroll">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">
            <img src="../img/logo-sm.png" style="width:150px; margin:0px;" />
          </a>
        </div>

        <div class="collapse navbar-collapse" id="navigation-example">
          <ul class="nav navbar-nav navbar-right">
              <li>
                <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
                  <i class="fa fa-twitter"></i>
                </a>
              </li>
              <li>
                <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
                  <i class="fa fa-facebook-square"></i>
                </a>
              </li>
              <li>
                <a href="#" target="_blank" class="btn btn-simple btn-white btn-just-icon">
                  <i class="fa fa-instagram"></i>
                </a>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="material-icons">settings</i>
                  <b class="caret"></b>
                </a>
                  <ul class="dropdown-menu dropdown-menu-right">
                      <li class="dropdown-header">configuraci&oacute;n</li>
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li>
                        <a href="#">
                          <i class="material-icons">exit_to_app</i>Cerrar Sesión
                        </a>
                      </li>
                  </ul>
              </li>
          </ul>
        </div>
    </div>
  </nav>
  <div class="wrapper">
    <div class="header header-filter" style="background-image: url('../img/bg-concert.jpg'); background-size: cover; background-position: top center;">
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <div class="card card-signup">
              <form class="form" method="post" action="">
                <div class="content">
                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">face</i>
                    </span>
                    <input type="text" class="form-control" placeholder="Nombre de Usuario">
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">email</i>
                    </span>
                    <input type="text" class="form-control" placeholder="Email">
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">music_video</i>
                    </span>
                    <input type="text" class="form-control" placeholder="Instrumento/Rol">
                  </div>

                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="material-icons">lock_outline</i>
                    </span>
                    <input type="password" placeholder="Contrase&ntilde;a" class="form-control" />
                  </div>
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" name="optionsCheckboxes" checked>
                      Suscribirme al newsletter
                    </label>
                  </div>
                </div>
                <div class="footer text-center">
                	<button class="btn btn-primary btn-round">
						<i class="material-icons">done</i>Registrarme!
					</button>
                </div>
                
                <div class="text-center">
                	<p class="text-divider">Ya tenés cuenta?
                		<a href="./login.jsp">Ingresá!</a>
                	</p>
                </div>
                
              </form>
            </div>
          </div>
        </div>
      </div>

      <footer class="footer">
        <div class="container">
          <nav class="pull-left">
            <ul>
              <li>
                <a href="http://www.creative-tim.com">
                  Soundmate
                </a>
              </li>
              <li>
                <a href="#">
                   Nosotros
                </a>
              </li>        
            </ul>
            </nav>
            <div class="copyright pull-right">
                &copy; 2016, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com" target="_blank">Equipo 7</a>
            </div>
        </div>
      </footer>
    </div>
  </div>
</body>

<!--   Core JS Files   -->
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="../js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="../js/bootstrap-datepicker.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="../js/material-kit.js" type="text/javascript"></script>

</html>
