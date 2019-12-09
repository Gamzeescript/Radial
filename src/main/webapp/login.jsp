<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Radio Hazbin -</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/Themebodies.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/radio.jpg" class="changesize">
            </div>
            <h1 align="center" class="texto">Iniciar sesion</h1>
        <div class="container mt-4 col-lg-4" >
            <div style="background-color: #000000" class="card col-sm-10">
                <div style="background-color: #000000" class="card-body">
                    <form action="usuario?action=login" method="POST">
                        <div class="form-group text-center">
                            <img src="img/lograd.png" alt="80" width="100"/><br>
                            <br>
                        <label id="textoblanco"> Usuario:</label>
                        <input type="text" class="form-control" name="usuario"/><br/><br/>  
                        </div>
                        <div class="form-group text-center">
                            <label id="textoblanco">Password:</label>
                        <input type="password" class="form-control form-control-sm" name="pass"/><br/><br/> 
                        </div>
                        <div class="form-group text-center">
                        <input type="submit" style="text-align: center;"  id="textoblanco" class="btn form-group text-center" value="Entrar" style="background-color: #FFFFFF" name="action">
                        <label id="textolabels">${msg}</label>
                    </form>
                    <br>
                    <a href="newuser.jsp" id="textolabels">Crear cuenta</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

            