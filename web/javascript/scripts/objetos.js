sys.objetos = {
    boton: {
        propiedades: {
            value: '',
            id: '',
            className: 'boton'
        },
        create: function(propiedades) {
            var boton = sys.create("button");
            sys.objetos.setPropiedades(boton, propiedades)
        }
    },
    setPropiedades: function(objeto, propiedades) {
        if(!objeto){
            return null;
        }
        for(var x in propiedades){
            objeto[x] = propiedades[x];
        }
    }
};