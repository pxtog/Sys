sys.opciones = {
    
    dhxWins: null,
    
    data : {
        personas: {
            urlLogo : 'imagenes/iconos/flat/user.png',
            nombre : 'Personas',
            descripcion : 'Administrador de Personas',
            url: 'personas.jsp',
            maximizar: true,
            tipo: 'ventana'
        },
        edificios: {
            urlLogo : 'imagenes/iconos/flat/company.png',
            nombre : 'Edificios',
            descripcion : 'Administrador de Edificios',
            maximizar: true
        },
        parqueos: {
            urlLogo : 'imagenes/iconos/flat/box.png',
            nombre : 'Parqueos',
            descripcion : 'Administrador de Parqueos'
            
        },
        usuarios: {
            urlLogo : 'imagenes/iconos/flat/admin.png',
            nombre : 'Usuarios',
            descripcion : 'Administrador de usuarios'
        },
        parqueo: {
            urlLogo : 'imagenes/iconos/flat/28.png',
            nombre : 'Parqueo',
            descripcion : 'Aplicación de Parqueo',
            url : 'parqueo.jsp',
            tipo: 'pagina'
        }
    },
    inicio: function(id){
        sys.opciones.dhxWins = new dhtmlXWindows();
        sys.opciones.dhxWins.attachViewportTo(id);
        sys.opciones.mostrarOpciones(id);
    },
    objetoOpcion: function(id){

        var opcion = sys.opciones.data[id];

        var d = sys.create("div");
        d.className = "opcion seleccion";
        d.id=id;
        
        var tb = sys.create("table");
        
        var lo = sys.create("img");
        lo.src = opcion.urlLogo;
        
        tb.insertRow(0);
        tb.insertRow(1);
                
        tb.rows[0].insertCell(0).className="imagen";
        tb.rows[0].insertCell(1).className="textoMedianoNegrita";
        tb.rows[1].insertCell(0).className="textoNormal";
        
        tb.rows[0].cells[0].appendChild(lo);
        tb.rows[0].cells[0].rowSpan = 2;
        tb.rows[0].cells[0].style.width = "70px";
        tb.rows[0].cells[1].innerHTML = opcion.nombre;
        tb.rows[1].cells[0].innerHTML = opcion.descripcion;
        
        d.appendChild(tb);
        
        return d;

    },
    abrirVentana: function(id){
        var data = sys.opciones.data[id];
        
        if(data.tipo && data.tipo === 'pagina'){
            
            window.open(data.url);
            
        }else{
        
            var w = data.ancho ? data.ancho : 500;
            var h = data.alto ? data.alto : 500;
            var v = sys.opciones.dhxWins.createWindow(data.id, 0, 0, w, h);
            v.center();
            v.setText(data.nombre);
            if(data.maximizar){
                v.maximize();
            }
            if(data.url){
                v.attachURL(data.url);
            }
            
        }
    },
    mostrarOpciones: function(id){

        var con = sys.get(id);

        for(var opcion in sys.opciones.data){
            var dv = sys.opciones.objetoOpcion(opcion);
            dv.onclick = function(){
                sys.opciones.abrirVentana(this.id);
            };
            con.appendChild(dv);
        }

    }
    
};
