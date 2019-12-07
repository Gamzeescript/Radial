<%-- 
    Document   : plantilla
    Created on : Dec 6, 2019, 10:57:39 PM
    Author     : Michelle Giron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a class="logo-wrap" href="Index.jsp">
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
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="producciom?action=mostrar">Producciones</a></li>
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
        <br><br><br><br><br><br><br><br><br>
          
            <!--========== tabla ==========-->
            
                <div class="container">
                    <div class="row">
                <div class="col-4"></div>
                <div class="col-8">
                    <h1 class="texto">Listado de Cargos</h1>
                    <table class="table table-light">
                        <thead class="texto">
                            <tr>
                                <td>id Cargo</td>
                                <td>Cargo</td>
                                <td>Descripcion</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody class="texto">
                            <c:forEach items="${lista}" var="c">
                                <tr>
                                    <td >${c.idcargo}</td>
                                    <td>${c.nombrecargo}</td>
                                    <td>${c.descripcion}</td>
                                    <td>
                                        <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${c.idcargo}', '${c.nombrecargo}', '${c.descripcion}')">Actualizar</button>
                                        <button type="button" class="btn btn-outline-info"  onclick="alerta_eliminar(${c.idcargo})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModal">Listar Cargos</button>

                    </div>
                                    </div>
                                    </div>
                
                    <!-- mi modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Registrar Cargo</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="cargo?action=insertar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Cargo:</label>
                                            <input type="text" class="form-control" name="nombrecargo" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label">Descripcion:</label>
                                            <textarea class="form-control" name="descripcion"></textarea>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-outline-dark" data-dismiss="modal">cerrar</button>
                                            <button class="btn btn-outline-info" onclick="reload(true)">Guardar</button>
                                        </div>
                                    </form>
                                </div>




                            </div>
                        </div>
                    </div>



                    <!-- fin modal -->     


                    <!-- Modal para actualizar -->

                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Cargo</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="cargo?action=actualizar">
                                        <label for="recipient-name" class="col-form-label">Id Cargo:</label>
                                            <input type="text" class="form-control" name="idcargo" id="idcargo" type="text" readonly="readonly">
                                        </div>
                                        <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Cargo:</label>
                                            <input type="text" class="form-control" name="nombrecargo" id="nombrecargo" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label">Descripcion:</label>
                                            <textarea class="form-control" name="descripcion" id="descripcion"></textarea>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-outline-dark" data-dismiss="modal">cerrar</button>
                                            <button class="btn btn-outline-info" onclick="reload(true)">Actualizar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    <!-- fin de modal de actualizar -->
                    
                    
                    <!-- Inicio de mis scripts -->

                    <script>
                        /* Apertura de modal con Jquery */

                        $('#.bd-example-modal-lg').modal(options);

                    </script>

                    <script type="text/javascript">
                        function editar(idcargo, nombrecargo, descripcion) {

                            /* Tomando los valores desde el javascript */
                            document.getElementById("idcargo").value = idcargo;
                            document.getElementById("nombrecargo").value = nombrecargo;
                            document.getElementById("descripcion").value = descripcion;

                        }
                    </script>
                    <script>
                          function alerta_eliminar(idcargo) {
                    Swal.fire({
                    title: 'De verdad, de verdad ¿quieres eliminar esta vaina?',
                    text: 'Sabemos de antemano que esta es una mala practica ¿Has pensado en solo ocultarlo? bueno... Procede si estas conciente de las consecuencias',
                    icon: 'warning',
                    cancelButtonText: "Cancelar",
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, Eliminar'
                }).then((result) => {
                    if (result.value) {
                        window.location.href = "cargo?action=eliminar&idcargo=" + idcargo;
                    }
                })
            }


                    </script>

            
            <div class="row" id="micolordiv">
            <div class="col-12" >
                <p id="textoblanco">Made with <i class="fa fa-heart" aria-hidden="true"></i> by Gamzeescript</p>  
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