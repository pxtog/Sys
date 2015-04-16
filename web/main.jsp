<%@page import="sys.Usuarios"%>
<%@page import="sys.util.Sistema" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="javascript/scripts/sistema.js"></script>
        <script src="javascript/scripts/opciones.js"></script>

        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/global.css">

        <title><%=Sistema.appName%></title>
        
        <script src="javascript/frameworks/dhtmlx/codebase/dhtmlx.js"></script>
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/dhtmlx/codebase/dhtmlx.css">
        
        <%
        
            if(session.getAttribute("usuario")==null){
                response.sendRedirect("index.jsp");
            }
        
            Usuarios cUsuario = (Usuarios) session.getAttribute("usuario"); 
        
        %>
        
    </head>
    <body>
        <div id="header">
            <div class="titulo" >
                <%=Sistema.appNameFull %>
            </div>
        </div>
        <div id="container">
            
        </div>
        <div id="fotter">
            <%=Sistema.empresaName%>
        </div>
        <script>
            sys.opciones.inicio("container");
        </script>
    </body>
</html>