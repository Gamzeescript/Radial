<%-- 
    Document   : registrouniverso
    Created on : 11-05-2019, 02:46:37 PM
    Author     : liliana.gironusam
--%>

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
                    <h1 align="center" class="texto">Encuesta de calidad</h1>
                    <h3 class="texto">En la siguiente encuesta encontraras los programas que estan actualmente al aire</h3>
                    <h3 class="texto">Tu opinion es importante y deseamos escucharte</h3>
                    <br>
                </div>
                <div class="col-8">
                    <form action="encuesta?action=insertar" method="POST">
                        <label for="recipient-name" class="col-form-label" id="textolabels">Usuario:</label>
                        <select name="idusuario" id="idusuario">
                            <option value="">-- Seleccione una opcion--</option>
                            <c:forEach items="${listausuario}" var="u">
                                <option value="${u.idusuario}">${u.usuario}</option>
                            </c:forEach>
                        </select>
                            <br>
                            <br>
                        <label for="recipient-name" class="col-form-label" id="textolabels">Programa:</label>
                        <select name="idprograma" id="idprograma">
                            <option value="">-- Seleccione una opcion--</option>
                            <c:forEach items="${listaprograma}" var="c">
                                <option value="${c.idprograma}">${c.nombreprograma}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <label for="recipient-name" class="col-form-label" id="textolabels">Calificacion:</label>
                        <select name="idrating" id="idrating">
                            <option value="">-- Seleccione una opcion--</option>
                            <c:forEach items="${listarating}" var="r">
                                <option value="${r.idrating}">${r.nombrerating}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <br>
                        <button class="btn btn-light">Califica</button>
                    </form>
                    <br>
                    <br>
                    <label id="textolabels">${msg}</label>
                    <br>
                    <a href="Index.jsp" id="textolabels">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>