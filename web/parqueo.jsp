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

        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/global.css">

        <title><%=Sistema.appName%></title>

        <script src="javascript/frameworks/dhtmlx/codebase/dhtmlx.js"></script>
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/dhtmlx/codebase/dhtmlx.css">

    </head>
    <body onload="parqueo.initParqueo();">
        <div id="header">
            <div class="titulo" >
                <%=Sistema.appNameFull%>
            </div>
        </div>

            <div id="contenedorSaludo">
                <div>
                    <%
                        String mensaje = request.getParameter("pd");
                        if(mensaje != null){
                            out.print(Salida.encMostrarMensaje(mensaje));
                        }
                    %>
                </div>
                <div class='titulo2Grande'>
                    Por favor acerque su tarjeta
                </div>
                <form id="formulario" action="parqueoEdificio.jsp" metho="post">
                    <input class='passOculto' type='password' id='inPwPersona' name='inPwPersona'>
                </form>
                <div id='contenedorReloj' class="reloj">

                </div>
            </div>

        <div id="fotter">
            <%=Sistema.empresaName%>
        </div>
    </body>
</html>