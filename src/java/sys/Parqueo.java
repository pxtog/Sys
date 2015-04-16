
package sys;

import java.sql.SQLException;
import sys.db.ResultSet;
import sys.db.Conexion;
import sys.util.Json;

public class Parqueo {
    
    Conexion conexion;
    
    Json datosPersona;
    String idPersona;
    String nombresPersona;
    
    int idClasificacion;
    int idClasificacionParqueo;
    String nombreClasificacion;
    
    public Parqueo() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        this.conexion = new Conexion("system.app.db");
        this.conexion.conectar();
    }
    public void close() throws SQLException{
        this.conexion.desconectar();
    }
    
    public String getDatosPersona(){
        return this.datosPersona.getString();
    }
    public String getIdPersona(){
        return this.idPersona;
    }
    public String getNombresPersona() {
        return nombresPersona;
    }
    public int getIdClasificacion() {
        return idClasificacion;
    }
    public String getNombreClasificacion() {
        return nombreClasificacion;
    }
    
    
    public boolean consultarPersona(String idPersona) throws SQLException{
        String consulta = " SELECT id_persona,nombres FROM sgp_personas where id_persona = '"+idPersona+"'";
        ResultSet resultado = this.conexion.consultar(consulta);
        if(resultado.next()){
            datosPersona = resultado.getJsonRow();
            this.idPersona = idPersona;
            this.nombresPersona = resultado.getString("nombres");
            this.consultarClasificacion(idPersona);
            return true;
        }else{
            return false;
        }
    }
    public void consultarClasificacion(String idPersona) throws SQLException{
        String consulta = 
            "SELECT \n" +
            "\t pc.id_clasificacion \n" +
            "\t ,cl.id_clasificacion_parqueo \n" +
            "\t ,cl.clasificacion \n" +
            "FROM sgp_persona_clasificacion pc \n" +
            "inner join sgp_clasificacion cl on \n" +
            "\t pc.id_clasificacion = cl.id_clasificacion \n" +
            "where pc.id_persona = '"+idPersona+"' ";
        ResultSet resultado = this.conexion.consultar(consulta);
        if(resultado.next()){
            this.idClasificacion = resultado.getInt("id_clasificacion");
            this.nombreClasificacion = resultado.getString("clasificacion");
            this.idClasificacionParqueo = resultado.getInt("id_clasificacion_parqueo");
        }else{
            this.idClasificacion = 0;
            this.nombreClasificacion = "Visitante";
            this.idClasificacionParqueo = 0;
        }
    }
    public String getEdificios() throws SQLException{
        String consulta = " SELECT id_edificio,edificio FROM sgp_edificios ";
        return this.conexion.consultar(consulta).getJsonArray().getString();
    }
    public String getParqueos() throws SQLException{
        String consulta = 
            "SELECT \n" +
            "\t id_edificio,\n" +
            "\t id_parqueo,\n" +
            "\t numero,\n" +
            "\t id_clasificacion_parqueo,\n" +
            "\t estado, \n" +
            "\t area\n" +
            "FROM sgp_parqueos\n" +
            "where \n" +
            "\t and id_clasificacion_parqueo = "+this.idClasificacionParqueo;
        return this.conexion.consultar(consulta).getJsonArray().getString();
    }
    
}
