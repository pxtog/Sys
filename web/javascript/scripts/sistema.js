sys = {
    get: function(id) {
        return document.getElementById(id);
    },
    c: function(o){
        console.log(o);
    },
    ajax: function(url, parametros, funcion) {
        
        var req = init();
        req.onreadystatechange = processRequest;
        
        function init() {
            if (window.XMLHttpRequest) {
                return new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function processRequest() {
            if (req.readyState === 1 || req.readyState === 3) { }
            if (req.readyState === 4) {
                if (req.status === 200) {
                    req = eval("(" + req.responseText + ")");
                    funcion(req);
                }
            }
        }
        this.doGet = function() {
            var fecha = new Date();
            var url2 = "" + url + "?" + parametros + "&sisFecha=" + fecha;
            req.open("GET", encodeURI(url2), true);
            req.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            req.send(null);
        };
        this.doPost = function() {
            var fecha = new Date();
            var url2 = "" + url + "?";
            req.open("POST", encodeURI(url2), true);
            req.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            req.send(parametros + "&sisFecha=" + fecha);
        };
    },
    create : function (tag){
         return document.createElement(tag);   
    },
    array : {
        extends: function extend(a, b) {
            var n;
            if (!a) {
                a = {};
            }
            for (n in b) {
                a[n] = b[n];
            }
            return a;
        }
    },
    fullScreen : function(){
        var docElm = document.documentElement;
        console.log(docElm);
        if (docElm.requestFullscreen) {
            console.log(1);
            docElm.requestFullscreen();
        }
        else if (docElm.mozRequestFullScreen) {
            console.log(2);
            docElm.mozRequestFullScreen();
        }
        else if (docElm.webkitRequestFullScreen) {
            console.log(3);
            docElm.webkitRequestFullScreen();
        }
        else if (docElm.msRequestFullscreen) {
            console.log(4);
            docElm.msRequestFullscreen();
        }
    }
};