
package sys.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

public class Salida {
    
    public static void print(String salida){
        System.out.println(salida);
    }
    public static void error(String salida){
        System.err.println(salida);
    }
    
    public static String encodeHTML(String input) throws UnsupportedEncodingException{
        return URLEncoder.encode(input, "UTF-8");
    }
    
    public static String encMostrarMensaje(String mensaje) throws NoSuchAlgorithmException{
        return Encriptador.desencriptar(mensaje);
    }
    public static String encEncriptarMensaje(String mensaje) {
        try {
            return Salida.encodeHTML(Encriptador.encriptar(mensaje));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return "";
        }
    }
    
}
