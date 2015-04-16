<%@page import="sys.util.Salida"%>
<%@page import="sys.util.Sistema" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="javascript/scripts/sistema.js"></script>
        <script src="javascript/scripts/opciones.js"></script>
        <script src="javascript/scripts/parqueo.js"></script>
        <script src="javascript/scripts/reloj.js"></script>
        
        <script src="javascript/frameworks/ol3/ol.js"></script>
        <script src="data/planoUsg.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/ol3/ol.css">

        <title><%=Sistema.appName%></title>

        <script src="javascript/frameworks/dhtmlx/codebase/dhtmlx.js"></script>
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/dhtmlx/codebase/dhtmlx.css">

    </head>
    <body onload="">
        <div id="header">
            <div class="titulo" >
                <%=Sistema.appNameFull%>
            </div>
        </div>

        <div id="container">
            <div id="map" class="map">

            </div>
        </div>

        <script src="javascript/scripts/map.js"></script>

        <div id="fotter">
            <%=Sistema.empresaName%>
        </div>
    </body>
</html>