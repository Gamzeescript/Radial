<%-- 
    Document   : menuprincipal
    Created on : 12-06-2019, 10:51:09 AM
    Author     : Gamzeescript
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion = request.getSession();
    String usuario;
    if(sesion.getAttribute("usuario")!=null){
        usuario = sesion.getAttribute("usuario").toString();
    }else{
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<!-- ==============================
    Project:        Metronic "Asentus" Frontend Freebie - Responsive HTML Template Based On Twitter Bootstrap 3.3.4
    Version:        1.0
    Author:         KeenThemes
    Primary use:    Corporate, Business Themes.
    Email:          support@keenthemes.com
    Follow:         http://www.twitter.com/keenthemes
    Like:           http://www.facebook.com/keenthemes
    Website:        http://www.keenthemes.com
    Premium:        Premium Metronic Admin Theme: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
================================== -->
<html lang="en" class="no-js">
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8"/>
        <title>Radio Hazbin</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="" name="description"/>
        <meta content="" name="author"/>

        <!-- GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
        <link href="vendor/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/Themebodies.css" rel="stylesheet" type="text/css"/>
         <link href="resources/iconos/iconos/iconos.css" rel="stylesheet" type="text/css"/>
        
        <!-- PAGE LEVEL PLUGIN STYLES -->
        <link href="css/animate.css" rel="stylesheet">
        <link href="vendor/swiper/css/swiper.min.css" rel="stylesheet" type="text/css"/>

        <!-- THEME STYLES -->
        <link href="css/layout.css" rel="stylesheet" type="text/css"/>

        <!-- Favicon -->
        <link rel="shortcut icon" href="favicon.ico"/>
    </head>
    <!-- END HEAD -->

    <!-- BODY -->
    <body>

        <!--========== HEADER ==========-->
        <header class="header navbar-fixed-top">
            <!-- Navbar -->
            <nav class="navbar" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="menu-container">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="toggle-icon"></span>
                        </button>

                        <!-- Logo -->
                        <div class="logo">
                            <a class="logo-wrap" href="menuprincipal.jsp">
                                <img class="logo-img logo-img-main" src="img/radio-on-button.png" alt="logo">
                                <img class="logo-img logo-img-active" src="img/radio-on-button.png" alt="Asentus Logo">
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse nav-collapse">
                        <div class="menu-container">
                            <ul class="navbar-nav navbar-nav-right">
                                <li class="nav-item"><a class="nav-item-child nav-item-hover active" href="Index.jsp">Inicio</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="cargo?action=mostrar">Cargos</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="empleado?action=mostrar">Empleados</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="cargoxempleado?action=mostrar">Staff</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="consorcio?action=mostrar">Consorcios</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="productora?action=mostrar">Productoras</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="produccion?action=mostrar">Producciones</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="encuesta?action=mostrar">Power BI - Estadisticas</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="usuario?action=mostrar">Usuario</a></li>
                            </ul>
                        </div>
                    </div>
                    <br>
                    <!-- End Navbar Collapse -->
                </div>
            </nav>
            <!-- Navbar -->
        </header>
        <!--========== END HEADER ==========-->

        <!--========== SLIDER ==========-->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <div class="container">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="5"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="6"></li>
                </ol>
            </div>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="img-responsive" src="img/radiohas.png" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h1 class="carousel-title">Programas de radio</h1>
                                <p>Las frecuencias radiales m&aacute;s populares del pa&iacute;s<br/> con mayor rating y emision</p>
                            </div>
                            <a href="programa?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="img-responsive" src="img/radiohas1.jpg" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Radio Difusoras Sv</h2>
                                <p>San Salvador numero uno en canales de radio<br/> desde 1930 sirviendo a la comunidad</p>
                            </div>
                            <a href="radio?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="img-responsive" src="img/radiohas2.jpg" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Emisiones</h2>
                                <p>Programaci&oacute;n radial de alta calidad<br/>Todos los dias en diversos horarios</p>
                            </div>
                            <a href="emision?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="img-responsive" src="img/radiohas3.jpg" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Transmisiones</h2>
                                <p>Cobertura impecable en transmision AM y PM<br/>Servicios de frecuencia incluso en sitios remotos</p>
                            </div>
                            <a href="transmision?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="img-responsive" src="img/radiohas4.png" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Frecuencias sintonizadas</h2>
                                <p>Llegamos a todos lados y a todos los rincones<br/>Se&nacute;ales potentes que exploran todas las longitudes de onda</p>
                            </div>
                            <a href="frecuencia?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="img-responsive" src="img/radiohas5.png" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Generos de nuestros programas</h2>
                                <p>Contamos con la variedad m&aacute;s extensa de generos<br/> Abarcamos cultura, edad y gustos personalizados</p>
                            </div>
                            <a href="genero?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="img-responsive" src="img/radiohas6.png" alt="Slider Image">
                    <div class="container">
                        <div class="carousel-centered">
                            <div class="margin-b-40">
                                <h2 class="carousel-title">Rating</h2>
                                <p>Nos caracterizamos por la calidad de nuestros productos<br/> buscando la sintonizacion en las radios</p>
                            </div>
                            <a href="rating?action=mostrar" class="btn-theme btn-theme-sm btn-white-brd text-uppercase">Administrar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--========== SLIDER ==========-->
        
        <div class="row" id="micolordiv">
            <div class="col-12" >
                <p id="textoblanco">Made with <i class="fa fa-heart" aria-hidden="true"></i> by Gamzeescript</p>  
                <p id="textoblanco"><a href="Index.jsp">Cerrar Sesion</a></p>  
            </div>
        </div>


        <!-- Back To Top -->
        <a href="javascript:void(0);" class="js-back-to-top back-to-top">Top</a>

        <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- CORE PLUGINS -->
        <script src="vendor/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL PLUGINS -->
        <script src="vendor/jquery.easing.js" type="text/javascript"></script>
        <script src="vendor/jquery.back-to-top.js" type="text/javascript"></script>
        <script src="vendor/jquery.smooth-scroll.js" type="text/javascript"></script>
        <script src="vendor/jquery.wow.min.js" type="text/javascript"></script>
        <script src="vendor/swiper/js/swiper.jquery.min.js" type="text/javascript"></script>
        <script src="vendor/masonry/jquery.masonry.pkgd.min.js" type="text/javascript"></script>
        <script src="vendor/masonry/imagesloaded.pkgd.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="js/layout.min.js" type="text/javascript"></script>
        <script src="js/components/wow.min.js" type="text/javascript"></script>
        <script src="js/components/swiper.min.js" type="text/javascript"></script>
        <script src="js/components/masonry.min.js" type="text/javascript"></script>

    </body>
    <!-- END BODY -->
</html>