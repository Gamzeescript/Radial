<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Radio Hazbin - Quality Survey</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/Themebodies.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/radio.jpg" class="changesize">
            </div>
            <div class="row">
                <div class="col-12">
                    <h1 align="center" class="texto">Creacion de nuevo usuario</h1>
                </div>
                <div class="col-8">
                    <form  method="POST" action="usuario?action=crearusuario">
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Nombre:</label>
                            <input type="text" class="form-control" name="nombre" type="text">
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Apellido:</label>
                            <input type="text" class="form-control" name="apellido" type="text">
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Usuario:</label>
                            <input type="text" class="form-control" name="usuario" type="text">
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Password:</label>
                            <input class="form-control" name="pass" type="password" >
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Email:</label>
                            <input type="text" class="form-control" name="email" type="text">
                            <label for="recipient-name" class="col-form-label" id="textoblanco">Telefono:</label>
                            <input type="text" class="form-control" name="telefono" type="text">
                            <br>                         
                            <button class="btn btn-light">Crear usuario</button>
                    </form>                    
                    <br>
                    <label id="textolabels">${msg}</label>
                    <br>
                    <a href="login.jsp" id="textolabels">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>