var reloj = {
  
    idObjeto: '',
  
    init : function (idObjeto) {
        
        reloj.idObjeto = idObjeto;
        reloj.getHora();
        
    },
    
    getHora : function (){
        
        var d = sys.get(reloj.idObjeto);
        d.innerHTML = "";
        
        var nowDate = new Date();
        var tn = ("0" + nowDate.getDate()).slice(-2) + '/' + ("0" + (nowDate.getMonth() + 1)).slice(-2);
        var sa = ("0" + nowDate.getHours()).slice(-2);
        sa += ':' + ("0" + nowDate.getMinutes()).slice(-2);
        sa += ':' + ("0" + nowDate.getSeconds()).slice(-2);
        sa = tn + " " + sa;
        d.innerHTML = sa;
        
        setTimeout(
            function(){
                reloj.getHora();
            }
        ,1000);
        
    }
    
    
    
}; 
