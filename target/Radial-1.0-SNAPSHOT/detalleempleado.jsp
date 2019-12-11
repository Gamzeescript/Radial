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
                    <h1 class="texto">Listado de Empleado</h1>
                    <table class="table table-light">
                        <thead id="textoblanco">
                            <tr>
                                <td>id Empleado</td>
                                <td>Nombre</td>
                                <td>Cedula</td>
                                 <td>Productora</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody id="textoblanco">
                            <c:forEach items="${lista}" var="em">
                                <tr>
                                    <td>${em.idempleado}</td>
                                    <td>${em.nombre}</td>
                                    <td>${em.cedula}</td>
                                    <td>${em.idproductora.nombreproductora}</td>
                                    <td>
                                        <button type="button" class="btn" value="primary" style="background-color: #708090"  data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${em.idempleado}', '${em.nombre}', '${em.cedula}', '${em.idproductora}')">Actualizar</button>
                                        <button type="button" class="btn btn-danger"  onclick="alerta_eliminar(${em.idempleado})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn" value="primary" style="background-color: #FFFFFF" data-toggle="modal" data-target="#exampleModal">Registro Empleados</button>

                </div>

                <!-- mi modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Registro Empleados</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form  method="POST" action="empleado?action=insertar">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Nombre Empleado:</label>
                                        <input type="text" class="form-control" name="nombre">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Cedula:</label>
                                        <input type="text" class="form-control" name="cedula">
                                    </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Casa Productora:</label>
                                            <select name="idproductora" id="idproductora">
                                                <option value="">-- Seleccione una opcion--</option>
                                                <c:forEach items="${listaproductora}" var="pd">
                                                    <option value="${pd.idproductora}">${pd.nombreproductora}</option>
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
                                <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Produccion</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form  method="POST" action="empleado?action=actualizar">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Id Empleado:</label>
                                        <input type="text" class="form-control" name="idempleado" id="idempleado" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Nombre Empleado:</label>
                                        <input type="text" class="form-control" name="nombre" id="nombre">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Cedula:</label>
                                        <input type="text" class="form-control" name="cedula" id="cedula">
                                    </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">Casa Productora:</label>
                                            <select name="idproductora" id="idproductora">
                                                <c:forEach items="${listaproductora}" var="pd">
                                                    <option value="${pd.idproductora}">${pd.nombreproductora}</option>
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
                <!-- fin de modal de actualizar -->


                <!-- Inicio de mis scripts -->

                <script>
                    /* Apertura de modal con Jquery */
                    $('#.bd-example-modal-lg').modal(options);
                </script>

                <script type="text/javascript">
                    $(document).ready(function () {
                        $('select').formSelect();
                    });
                    function editar(idempleado, nombre, cedula, idproductora) {
                        /* Tomando los valores desde el javascript */
                        document.getElementById("idempleado").value = idempleado;
                        document.getElementById("nombre").value = nombre;
                        document.getElementById("cedula").value = cedula;
                        document.getElementById("idproductora").value = idproductora;
                    }
                </script>
                <script>
                    function alerta_eliminar(idempleado) {
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
                                window.location.href = "empleado?action=eliminar&idempleado=" + idempleado;
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