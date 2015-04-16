
package sys.util;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import sys.db.Conexion;


/**
 *
 * @author PXTO
 */
public class NewMain {


    public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Salida.print(Encriptador.encriptar("jdbc:mysql://localhost:3306/sgp"));
        Salida.print(Encriptador.encriptar("patricio.guzman"));

        JsonArray ja = new JsonArray();

        Json j = new Json();

        j.add("p1", "");
        j.add("p2", 1);

        j.add("p3", new Json().add("p31", 1));

        ja.add(j);
        ja.add(j);
        
        System.out.println(ja.getString());
       
        Conexion conexion = new Conexion("system.app.db");
        conexion.conectar();
        
        
        System.out.println(conexion.getJsonArray("SELECT * FROM sgp.sgp_edificios;").getString());
        
        
    }
    
}
