
package sys;


import com.dhtmlx.connector.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sys.db.Conexion;

public class ConectorPersonas extends ThreadSafeConnectorServlet {

    @Override
    protected void configure(HttpServletRequest req, HttpServletResponse res) {
        
        Conexion conexion = null;
        
        try {
            
            conexion = new Conexion("system.app.db");
            conexion.conectar();
            
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConectorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GridConnector c = new GridConnector(conexion.getConector());
        
        //c.sql.attach(OperationType.UPDATE,"Update tableA set name='{name}', price={price} where id={id}");
        
        
        
        c.servlet(req, res);
        c.render_table("sgp_personas", "id_persona", "id_persona,nombres,telefono,correo,cargo");
        
        try {
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

   

}
