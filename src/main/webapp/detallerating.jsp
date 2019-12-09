<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
         <!--include de mi header  -->
        <jsp:include page="/menu.jsp"/>
          
            <!--========== tabla ==========-->
            <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-8">
                    <h1>Escala de Rating</h1>
                    <table class="table table-light">
                        <thead id="textoblanco">
                            <tr>
                                <td>id Rating</td>
                                <td>Rating</td>
                                <td>Descripcion</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody id="textoblanco">
                            <c:forEach items="${lista}" var="r">
                                <tr>
                                    <td>${r.idrating}</td>
                                    <td>${r.nombrerating}</td>
                                    <td>${r.descripcion}</td>
                                    <td>
                                        <button type="button" class="btn" value="primary" style="background-color: #708090" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${r.idrating}', '${r.nombrerating}', '${r.descripcion}')">Actualizar</button>
                                        <button type="button" class="btn btn-danger"  onclick="alerta_eliminar(${r.idrating})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn" value="primary" style="background-color: #FFFFFF" data-toggle="modal" data-target="#exampleModal">Listar Rating</button>

                    </div></div></div>
                
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
                                    <form  method="POST" action="rating?action=insertar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Rating:</label>
                                            <input type="text" class="form-control" name="nombrerating" type="text">
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
                                    <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Rating</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="rating?action=actualizar">
                                        <label for="recipient-name" class="col-form-label">Id Rating:</label>
                                            <input type="text" class="form-control" name="idrating" id="idrating" type="text" readonly="readonly">
                                        </div>
                                        <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Rating:</label>
                                            <input type="text" class="form-control" name="nombrerating" id="nombrerating" type="text">
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
                        function editar(idrating, nombrerating, descripcion) {

                            /* Tomando los valores desde el javascript */
                            document.getElementById("idrating").value = idrating;
                            document.getElementById("nombrerating").value = nombrerating;
                            document.getElementById("descripcion").value = descripcion;

                        }
                    </script>
                    <script>
                          function alerta_eliminar(idrating) {
                    Swal.fire({
                    title: 'ATENCION: esta a punto de borrar un registro',
                    text: 'Esta accion no puede deshacerse',
                    icon: 'warning',
                    cancelButtonText: "Cancelar",
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, Eliminar'
                }).then((result) => {
                    if (result.value) {
                        window.location.href = "rating?action=eliminar&idrating=" + idrating;
                    }
                })
            }
                    </script>
                    
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
                    
                    
                     <!-- fin de mis scripts -->

    </body>
</html>





