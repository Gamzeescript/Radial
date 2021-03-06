<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<html>
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
    <body>
        <!--include de mi header  -->
        <jsp:include page="/menu.jsp"/>
        
            <!-- Inicio de tabla -->
            
            <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-8">
                    <h1 class="texto">Listado de Consorcios</h1>
                    <table class="table table-light">
                        <thead id="textoblanco">
                            <tr>
                                <td>id Consorcio</td>
                                <td>Nombre</td>
                                <td>RFC</td>
                                <td>Telefono</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody id="textoblanco">
                            <c:forEach items="${lista}" var="con">
                                <tr>
                                    <td>${con.idconsorcio}</td>
                                    <td>${con.nombreconsorcio}</td>
                                    <td>${con.rfc}</td>
                                    <td>${con.telefono}</td>
                                    <td>
                                        <button type="button" class="btn" value="primary" style="background-color: #708090" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${con.idconsorcio}', '${con.nombreconsorcio}', '${con.rfc}', '${con.telefono}')">Actualizar</button>
                                        <button type="button" class="btn btn-danger"  onclick="alerta_eliminar(${con.idconsorcio})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn" value="primary" style="background-color: #FFFFFF" data-toggle="modal" data-target="#exampleModal">Agregar  Consorcio</button>

                    </div>
                </div>
                </div>
                
                    <!-- mi modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Registrar Consorcio</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="consorcio?action=insertar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Nombre:</label>
                                            <input type="text" class="form-control" name="nombreconsorcio" type="text" max="2">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">RFC:</label>
                                            <input type="text" class="form-control" name="rfc" type="text" max="2">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Telefono:</label>
                                            <input type="text" class="form-control" name="telefono" type="text" max="2">
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
                                    <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Consorcio</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  method="POST" action="consorcio?action=actualizar">
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Id consorcio:</label>
                                            <input type="text" class="form-control" name="idconsorcio" id="idconsorcio" readonly="readonly" type="number" max="2">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Nombre:</label>
                                            <input type="text" class="form-control" name="nombreconsorcio" id="nombreconsorcio" type="number" max="2">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">RFC:</label>
                                            <input type="text" class="form-control" name="rfc" id="rfc" type="number" max="2">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Telefono:</label>
                                            <input type="text" class="form-control" name="telefono" id="telefono" type="number" max="2">
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
                        function editar(idconsorcio, nombreconsorcio, rfc, telefono) {

                            /* Tomando los valores desde el javascript */
                            document.getElementById("idconsorcio").value = idconsorcio;
                            document.getElementById("nombreconsorcio").value = nombreconsorcio;
                            document.getElementById("rfc").value = rfc;
                            document.getElementById("telefono").value = telefono;

                        }
                    </script>
                    <script>
                          function alerta_eliminar(idconsorcio) {
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
                        window.location.href = "consorcio?action=eliminar&idconsorcio=" + idconsorcio;
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





