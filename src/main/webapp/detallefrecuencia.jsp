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
                    <h1 class="texto">Listado de Frecuencias</h1>
                    <table class="table table-light">
                        <thead id="textoblanco">
                            <tr>
                                <td>id Frecuencia</td>
                                <td>Nombre frecuencia</td>
                                <td>descripcion</td>
                                <td>frecuencia</td>
                                <td>Transmision</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody id="textoblanco">
                            <c:forEach items="${lista}" var="f">
                                <tr>
                                    <td>${f.idfrecuencia}</td>
                                    <td>${f.nombrefrecuencia}</td>
                                    <td>${f.descripcion}</td>
                                    <td>${f.frecuencia}</td>
                                     <td>${f.idtransmision.nombretransmision}</td>
                                    <td>
                                        <button type="button" class="btn" value="primary" style="background-color: #708090" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${f.idfrecuencia}', '${f.nombrefrecuencia}', '${f.descripcion}', '${f.frecuencia}', '${f.idtransmision}')">Actualizar</button>
                                        <button type="button" class="btn btn-danger"  onclick="alerta_eliminar(${f.idfrecuencia})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModal">Agregar  Frecuencia</button>

                    </div></div></div>
                
                    <!-- mi modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Registrar Frecuencia</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="frecuencia?action=insertar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Nombre frecuencia:</label>
                                            <input type="text" class="form-control" name="nombrefrecuencia">
                                        </div>
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label">Descripcion:</label>
                                            <textarea class="form-control" name="descripcion"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Frecuencia:</label>
                                            <input type="text" class="form-control" name="frecuencia">
                                        </div>
                                       <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Transmision:</label>
                                            <select name="idtransmision" id="idtransmision">
                                            <option value="">-- Seleccione una opcion--</option>
                                            <c:forEach items="${listatransmision}" var="t">
                                                <option value="${t.idtransmision}">${t.nombretransmision}</option>
                                            </c:forEach>
                                             </select>
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
                                    <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Frecuencia</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="frecuencia?action=actualizar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Id frecuencia:</label>
                                            <input type="text" class="form-control" name="idfrecuencia" id="idfrecuencia" readonly="readonly">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Nombre frecuencia:</label>
                                            <input type="text" class="form-control" name="nombrefrecuencia" id="nombrefrecuencia">
                                        </div>
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label">Descripcion:</label>
                                            <textarea class="form-control" name="descripcion" id="descripcion"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Frecuencia:</label>
                                            <input type="text" class="form-control" name="frecuencia" id="frecuencia" type="text">
                                        </div>
                                       <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Transmision:</label>
                                            <select name="idtransmision" id="idtransmision">
                                            <c:forEach items="${listatransmision}" var="t">
                                                <option value="${t.idtransmision}">${t.nombretransmision}</option>
                                            </c:forEach>
                                             </select>
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
                    <!-- fin de modal de actualizar -->
                    
                    
                    <!-- Inicio de mis scripts -->

                    <script>
                        /* Apertura de modal con Jquery */

                        $('#.bd-example-modal-lg').modal(options);

                    </script>

                    <script type="text/javascript">
                        
                        $(document).ready(function(){
                              $('select').formSelect();
                          });
                        
                        function editar(idfrecuencia, nombrefrecuencia, descripcion, frecuencia, idtransmision) {

                            /* Tomando los valores desde el javascript */
                            document.getElementById("idfrecuencia").value = idfrecuencia;
                            document.getElementById("nombrefrecuencia").value = nombrefrecuencia;
                            document.getElementById("descripcion").value = descripcion;
                            document.getElementById("frecuencia").value = frecuencia;
                            document.getElementById("idtransmision").value = idtransmision;


                        }
                    </script>
                    <script>
                          function alerta_eliminar(idfrecuencia) {
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
                        window.location.href = "frecuencia?action=eliminar&idfrecuencia=" + idfrecuencia;
                    }
                })
            }


                    </script>
                    
                    
                     <!-- fin de mis scripts -->
                    
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