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
        <link href="css/mitoggle.css" rel="stylesheet" type="text/css"/>
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
                    <h1>Listado de Emision</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <td>id Emision</td>
                                <td>Nombre Programa</td>
                                <td>Fecha inicio</td>
                                <td>Hora Inicio</td>
                                <td>Fecha Finalizacion</td>
                                <td>hora fin</td>
                                <td>Duracion</td>
                                <td>Repeticion</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista}" var="e">
                                <tr>
                                    <td>${e.idemision}</td>
                                    <td>${e.idprograma.nombreprograma}</td>
                                    <td>${e.fechainicio}</td>
                                    <td>${e.horainicio}</td>
                                    <td>${e.fechafin}</td>
                                    <td>${e.horafin}</td>
                                    <td>${e.duracion}</td>
                                    <td>${e.repeticion}</td>
                                    <td>
                                        <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${e.idemision}', '${e.idprograma}', '${e.fechainicio}', '${e.horainicio}', '${e.fechafin}', '${e.horafin}', '${e.duracion}', '${e.repeticion}')">Actualizar</button>
                                        <button type="button" class="btn btn-outline-danger"  onclick="alerta_eliminar(${e.idemision})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModal">Agregar  Radio</button>

                </div>

                <!-- mi modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Registrar Radio</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form  method="POST" action="emision?action=insertar">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Prograna:</label>
                                        <select name="idprograma" id="idprograma">
                                            <option value="">-- Seleccione una opcion--</option>
                                            <c:forEach items="${listaprograma}" var="c">
                                                <option value="${c.idprograma}">${c.nombreprograma}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">fecha inicio:</label>
                                        <input type="date" class="form-control" name="fechainicio">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">horario inicio:</label>
                                        <input type="time" class="form-control" name="horainicio">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">fecha fin:</label>
                                        <input type="date" class="form-control" name="fechafin">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">horario fin:</label>
                                        <input type="time" class="form-control" name="horafin">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">duracion:</label>
                                        <input type="text" class="form-control" name="duracion" type="text">
                                    </div>
                                    <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Repeticion:</label>
                                    <label class="switch">
                                        <input type="checkbox" data-on="Yup" data-off="Nope" value="Nope">
                                        <span class="slider round">
                                            <span class="on">Si</span>
                                            <span class="off">No</span>
                                        </span>
                                    </label>
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
                                <h5 class="modal-title" id="exampleModalCenterTitle">Actualizar Radio</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form  method="POST" action="emision?action=actualizar">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Id Emision:</label>
                                        <input type="text" class="form-control" name="idemision" id="idemision" readonly="readonly">
                                    </div>
                                        <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Programa:</label>
                                        <select name="idprograma" id="idprograma">
                                            <c:forEach items="${listaprograma}" var="c">
                                                <option value="${c.idprograma}">${c.nombreprograma}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">fecha inicio:</label>
                                        <input type="date" class="form-control" name="fechainicio" id="fechainicio">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">horario inicio:</label>
                                        <input type="time" class="form-control" name="horainicio" id="horainicio">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">fecha fin:</label>
                                        <input type="date" class="form-control" name="fechafin" id="fechafin">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">horario fin:</label>
                                        <input type="time" class="form-control" name="horafin" id="horafin">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">duracion:</label>
                                        <input type="text" class="form-control" name="duracion" type="text" id="duracion">
                                    </div>
                                    <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Repeticion:</label>
                                    <label class="switch">
                                        <input type="checkbox" name="repeticion" id="repeticion"  data-on="1" data-off="0">
                                        <span class="slider round">
                                        <span class="on">Si</span>
                                        <span class="off">No</span>
                                        </span>
                                    </label>
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
                        function editar(idemision, idprograma, fechainicio, horainicio, fechafin, horafin, duracion, repeticion) {

                             /* Tomando los valores desde el javascript */
                                document.getElementById("idemision").value = idemision;
                                document.getElementById("idprograma").value = idprograma;
                                document.getElementById("fechainicio").value = fechainicio;
                                document.getElementById("horainicio").value = horainicio;
                                document.getElementById("fechafin").value = fechafin;
                                document.getElementById("horafin").value = horafin;
                                document.getElementById("duracion").value = duracion;
                                document.getElementById("repeticion").value = repeticion;
                                    }
                                    </script>
                               <script>
                          function alerta_eliminar(idemision) {
                    Swal.fire({
                    title: 'Advertencia: Esta a punto de borrar un registro',
                    text: 'Sabemos de antemano que esta es una mala practica ¿Has pensado en solo ocultarlo? bueno... Procede si estas conciente de las consecuencias',
                    icon: 'warning',
                    cancelButtonText: "Cancelar",
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, Eliminar'
                }).then((result) => {
                    if (result.value) {
                        window.location.href = "emision?action=eliminar&idemision=" + idemision;
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