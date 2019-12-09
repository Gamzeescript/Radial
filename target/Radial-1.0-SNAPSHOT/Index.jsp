<%-- 
    Document   : inicio
    Created on : Dec 5, 2019, 9:37:39 PM
    Author     : Michelle Giron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/Theme.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <title>Hazbin Radio</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                <h1 id="tema">The Hazbin Radio</h1>
                </div>
            </div>
            <div class="row">
                    <div class="col-6">
                        <img src="img/antenna.png" id="imagen"/>
                    </div>      
                    <div class="col-6">
                        ´<div id="centrador">
                            <img src="img/survey.png" id="imagen"/> 
                    </div>
                        </div>
                </div> 
            <div class="row">
                <div class="col-6">
                    <a href="login.jsp" class="texto"><h4 id="imagen">Radio Admin</h4></a>
                </div>    
                
                 <div class="col-6">
                     <a href="encuesta?action=encuesta" class="texto"><h4 id="imagen">Encuesta</h4></a>
                </div> 
            </div>
        
        </div>
    </body>
</html>
