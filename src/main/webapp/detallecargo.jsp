<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/bootstrap.bundle.js" type="text/javascript"></script>
        <link href="css/menucss.css" rel="stylesheet" type="text/css"/>
        <link href="font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> 
        <title>Radio Hazbin</title>
    </head>
    <body>
        <!-- seccion de menu -->

        <div class="container">
            <div class="row">
                <div class="col-8" style="margin-left:-200px">
                    <div class="nav-side-menu">
                        <div class="brand">The Cinema - Admin Panel</div>
                        <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

                        <div class="menu-list">

                            <ul id="menu-content" class="menu-content collapse out">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-dashboard fa-lg"></i> Volver al Portal de Cine
                                    </a>
                                </li>

                                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                                    <a href="#"><i class="fa fa-gift fa-lg"></i> Administraci&oacute;n de Cines <span class="arrow"></span></a>
                                </li>
                                <ul class="sub-menu collapse" id="products">
                                    <li class="active"><a href="#">Cines existentes</a></li>
                                    <li><a href="butaca?action=mostrar">Salas de cine</a></li>
                                    <li><a href="butaca?action=mostrar">Butacas</a></li>
                                    <li><a href="butaca?action=mostrar">Formatos existentes</a></li>
                                    <li><a href="butaca?action=mostrar">Funciones</a></li>
                                    <li><a href="butaca?action=mostrar">Promoci&oacute;n</a></li>
                                </ul>

                                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                                    <a href="#"><i class="fa fa-gift fa-lg"></i>Administraci&oacute;n de peliculas<span class="arrow"></span></a>
                                </li>
                                <ul class="sub-menu collapse" id="products">
                                    <li class="active"><a href="#">Peliculas Disponibles</a></li>
                                    <li><a href="titulo?action=mostrar">Titulos de peliculas</a></li>
                                    <li><a href="genero?action=mostrar">Genero</a></li>
                                    <li><a href="actor?action=mostrar">Actores</a></li>
                                    <li><a href="director?action=mostrar">Directores</a></li>
                                    <li><a href="reparto?action=mostrar">Reparto de pel&iacute;culas</a></li>
                                    <li><a href="clasificacion?action=mostrar">Clasificaci&oacute;n</a></li>
                                    <li><a href="calificacion?action=mostrar">Calificaci&oacute;n</a></li>

                                </ul>

                                <li data-toggle="collapse" data-target="#service" class="collapsed">
                                    <a href="#"><i class="fa fa-globe fa-lg"></i>Otros ajustes<span class="arrow"></span></a>
                                </li>  
                                <ul class="sub-menu collapse" id="service">
                                    <li>Idiomas</li>
                                    <li>Paises</li>
                                </ul>


                                <li data-toggle="collapse" data-target="#new" class="collapsed">
                                    <a href="#"><i class="fa fa-car fa-lg"></i><span class="arrow">Ticketeria</span></a>
                                </li>
                                <ul class="sub-menu collapse" id="new">
                                    <li>Ver tickets</li>
                                    <li>Reserva de Tickets</li>
                                    <li>Compra de Tickets</li>
                                </ul>


                                <li>
                                    <a href="#">
                                        <i class="fa fa-user fa-lg"></i> Usuarios
                                    </a>
                                </li>

                                <li>
                                    <a href="#">
                                        <i class="fa fa-users fa-lg"></i> Secci&oacute;n de opiniones
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- fin de menu -->
            
            <!-- Inicio de tabla -->
            
            
            <div class="row">
                <div class="col-4"></div>
                <div class="col-8">
                    <h1>Listado de Cargos</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <td>id Cargo</td>
                                <td>Cargo</td>
                                <td>Descripcion</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista}" var="c">
                                <tr>
                                    <td>${c.idcargo}</td>
                                    <td>${c.nombrecargo}</td>
                                    <td>${c.descripcion}</td>
                                    <td>
                                        <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${c.idcargo}', '${c.nombrecargo}', '${c.descripcion}')">Actualizar</button>
                                        <button type="button" class="btn btn-outline-danger"  onclick="alerta_eliminar(${c.idcargo})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModal">Listar Cargos</button>

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
                    
                    
                     <!-- fin de mis scripts -->
                    
                    
                </div>
            </div>
        </div>
    </body>
</html>





