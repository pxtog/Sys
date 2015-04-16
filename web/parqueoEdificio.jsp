<%@page import="sys.util.Salida"%>
<%@page import="sys.Parqueo"%>
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

        <%
        
            Boolean devolver = false;
            String mensaje = "";
            
            String idPersona = request.getParameter("inPwPersona");
            Parqueo parqueo = new Parqueo();
            
            if(idPersona == null || idPersona.replace(" ", "").equals("")){
                devolver = true;
                mensaje = "No se ingreso información para buscar";
            }else{
                if(!parqueo.consultarPersona(idPersona)){
                    devolver = true;
                    mensaje = "Persona no ingresada";
                }
            }
            
            if(devolver){
                response.sendRedirect("parqueo.jsp?pd="+Salida.encEncriptarMensaje(mensaje));
            }
           
        %>
        
        <script>
            
            var edificios = <%=parqueo.getEdificios()%>;
            var parqueos = <%=parqueo.getEdificios()%>;
            
        </script>
        
    </head>
    <body onload="parqueo.initAsignacion();">
        <div id="header">
            <div class="titulo" >
                <%=Sistema.appNameFull%>
            </div>
        </div>

            <div id="container">
                <div class='titulo2Grande div100 marginTB'>
                    Bienvenido(a) <% out.print(parqueo.getNombresPersona()); %>
                    <div class="textoNormal" >
                        <%= parqueo.getNombreClasificacion() %>
                    </div>
                </div>
                <div class='titulo2 div100 marginTB' style="text-align: center;">
                    Escoja el edificio al que se dirige
                </div>
                <div class="div100 marginTB">
                    
                </div>
            </div>

        <div id="fotter">
            <%=Sistema.empresaName%>
        </div>
        <%
            parqueo.close();
        %>
    </body>
</html>