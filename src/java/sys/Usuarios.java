
package sys;

import java.sql.SQLException;
import sys.db.Conexion;
import sys.db.ResultSet;

public class Usuarios {
    
    String idUsuario;
    String usuario;
    String tipo;
            
    Conexion conexion;
    
    public Usuarios(String usuario) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        this.usuario = usuario.replace("'","").trim();
        this.conexion = new Conexion("system.app.db");
    }

    public String getIdUsuario() {
        return idUsuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getTipo() {
        return tipo;
    }
    
    public boolean validarUsuario(String clave) throws SQLException{
        
        boolean salida = false;
        
        this.conexion.conectar();
        String consulta = " SELECT id_usuario,estado,clave,tipo FROM sgp_usuarios where usuario = '"+this.usuario+"' ";
        ResultSet resultado = this.conexion.consultar(consulta);
        if(resultado.next()){
            if(resultado.getString("clave").equals(clave) && resultado.getInt("estado") == 1){
                this.idUsuario = resultado.getString("id_usuario");
                this.tipo = resultado.getString("tipo");
                salida = true;
            }
        }
        
        this.conexion.desconectar();
        return salida;

    }
    
}
