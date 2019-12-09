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
                    <h1 class="texto">Listado de Emision</h1>
                    <table class="table table-light">
                        <thead id="textoblanco">
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
                        <tbody id="textoblanco">
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
                                        <button type="button" class="btn" value="primary" style="background-color: #708090" value="primary" data-toggle="modal" data-target="#exampleModalCenter" onclick="editar('${e.idemision}', '${e.idprograma}', '${e.fechainicio}', '${e.horainicio}', '${e.fechafin}', '${e.horafin}', '${e.duracion}', '${e.repeticion}')">Actualizar</button>
                                        <button type="button" class="btn btn-danger"  onclick="alerta_eliminar(${e.idemision})"><a>Eliminar</a></button>
                                    </td>
                                </tr>
                            </c:forEach>                                
                        </tbody>
                    </table>    
                    <br><br>
                    <!-- Trigger -->
                    <button type="button" class="btn" value="primary" style="background-color: #FFFFFF" data-toggle="modal" data-target="#exampleModal">Agregar  Radio</button>

                </div></div></div>

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