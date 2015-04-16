
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Personas</title>
        
        <script src="javascript/frameworks/dhtmlx/conector/dhtmlx.js"></script>
        <script src="javascript/frameworks/dhtmlx/conector/dhtmlxdataprocessor.js"></script>
        <script src="javascript/frameworks/dhtmlx/conector/connector.js"></script>
        
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/dhtmlx/conector/dhtmlx.css">
        <link rel="stylesheet" type="text/css" href="javascript/frameworks/dhtmlx/skins/terrace/dhtmlx.css">
        
    </head>
    <body onload="load();" style="padding: 0px; margin: 0px;">
        
        <div id="someContainer" style="height: 500px;">
            
        </div>
        <script>
            function load (){
                
                var g;
                
                g = new dhtmlXGridObject("someContainer");
                g.setImagePath("javascript/frameworks/dhtmlx/skins/terrace/imgs/dhxgrid_terrace/");
                g.setHeader("Identificacion, Nombres, Telefono, Correo, Cargo");
                g.attachHeader("#connector_text_filter,#connector_text_filter,#connector_text_filter");
                g.setColTypes("ed,ed,ed,ed,ed");
                g.setColSorting("connector,connector,connector,connector,connector");
                g.enableSmartRendering(true);
                g.enableMultiselect(true);
                g.setSkin("dhx_terrace");
                g.init();
                g.loadXML("conPersonas");
                
                dp = new dataProcessor("conPersonas");
                dp.init(g);
                
            }
        </script>
    </body>
</html>
