var parqueo = {
    
    edificios : [],
    
    initParqueo : function(){
        
        var texto = sys.get("inPwPersona");
        texto.focus();
        
        texto.onblur = function(){
            sys.get("formulario").submit();
        };
        
        var contenedor = sys.get("contenedorSaludo");
        contenedor.onclick = function(){
            sys.get("inPwPersona").focus();
        };
        
        contenedor = sys.get("contenedorReloj");
        contenedor.onclick = function(){
            sys.get("inPwPersona").focus();
        };
        
        reloj.init("contenedorReloj");
        
    },
    
    initAsignacion : function(){
        parqueo.mostrarEdificios("container");
    },
    objetoEdificio: function(id){

        var opcion = parqueo.edificios[id];

        var d = sys.create("div");
        d.className = "opcion2 seleccion";
        d.id=id;
        
        var tb = sys.create("table");
        
        var lo = sys.create("img");
        lo.src = "imagenes/iconos/flat/company.png";
        
        tb.insertRow(0);
        tb.insertRow(1);
        tb.style.width = "500px";
                
        tb.rows[0].insertCell(0).className="imagen";
        tb.rows[0].insertCell(1).className="textoGrande";
        
        
        tb.rows[0].cells[0].appendChild(lo);
        tb.rows[0].cells[0].rowSpan = 2;
        tb.rows[0].cells[0].style.width = "70px";
        tb.rows[0].cells[1].innerHTML = opcion.edificio;
        
        d.appendChild(tb);
        
        return d;

    },
    mostrarEdificios : function(id){
        
        var con = sys.get(id);
        
        parqueo.edificios = {};
        
        for(var i in edificios){
            parqueo.edificios[i] = edificios[i];
        }
        
        for(var i in parqueo.edificios){
            var ob = parqueo.objetoEdificio(i);
            con.appendChild(ob);
        }
        
    }
    
};