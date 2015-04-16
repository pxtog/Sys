<%@page import="sys.Usuarios"%>
<%@page import="sys.util.Sistema" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="javascript/scripts/sistema.js"></script>
        <script src="javascript/scripts/login.js"></script>

        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/global.css">

        <title><%=Sistema.appName%></title>

    </head>
    <body>
        
        <%
        
            String usuario = request.getParameter("user");
            String clave = request.getParameter("pass");
            
            if(usuario != null){
            
                Usuarios cUsuario = new Usuarios(usuario); 

                if(cUsuario.validarUsuario(clave)){
                    session.setAttribute("usuario", cUsuario);                    
                    response.sendRedirect("main.jsp");
                }else{
                %>
                    <div class="titulo2" style="text-align: center; padding: 20px;">
                        Usuario o Contraseña incorrectos.
                    </div>
                <%
                }
            
            }
         
        %>
        
        <div id="login">
            <div class="tituloGrande">
                <%=Sistema.appName%>
            </div>
            <div align="center" style="padding: 30px 0 10px 0;">
                Iniciar Sesión
            </div>
            <div style="width: 100%; overflow: hidden;">
                <form method="POST" action="index.jsp">
                    <input type="user" name="user" id="user" class="input" placeholder="Usuario"/>
                    <input type="password" name="pass" id="pass" class="input" placeholder="Clave"/>
                    <input type="submit" class="button" value="Ingresar">
                </form>
            </div>
        </div>
        <div id="fotter">
            <%=Sistema.empresaName%>
        </div>
    </body>
</html>