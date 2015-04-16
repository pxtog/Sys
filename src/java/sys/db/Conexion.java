package sys.db;

import java.sql.CallableStatement;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sys.util.Encriptador;
import sys.util.JsonArray;

public class Conexion {

    private Connection conector;
    
    private String url;
    private String clase;
    private String usuario;
    private String clave;
    
    public PreparedStatement preparedStatement = null;
    public CallableStatement callableStatement = null;

    public String getClase(){
        return this.clase;
    }
    public void setClase(String vgClase){
        this.clase = vgClase;
    }
    
    public Connection getConector(){
        return this.conector;
    }
    public void setConector(Connection conector){
        this.conector = conector;
    }
    
    public String getClave(){
        return this.clave;
    }
    public void setClave(String password){
        this.clave = password;
    }
    
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String vgUrl){
        this.url = vgUrl;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String vgUsuario){
        this.usuario = vgUsuario;
    }

    public Conexion(){
    
    }
    public Conexion(String clase, String url, String usuario, String clave){

        this.clase = clase;
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;

    }
    public Conexion(String db){

        ResourceBundle rb = ResourceBundle.getBundle("sys.config");

        this.clase = rb.getString(db+".clase");
        this.url = (rb.getString(db+".url"));
        this.usuario = (rb.getString(db+".user"));
        this.clave = (rb.getString(db+".pass"));

    }
    
    public Conexion(String db, boolean encriptado){

        ResourceBundle rb = ResourceBundle.getBundle("sys.config");

        if(encriptado){
        
            this.clase = rb.getString(db+".clase");
            this.url = Encriptador.desencriptar(rb.getString(db+".url"));
            this.usuario = Encriptador.desencriptar(rb.getString(db+".user"));
            this.clave = Encriptador.desencriptar(rb.getString(db+".pass"));
        
        }else{
            
            this.clase = rb.getString(db+".clase");
            this.url = (rb.getString(db+".url"));
            this.usuario = (rb.getString(db+".user"));
            this.clave = (rb.getString(db+".pass"));
            
        }

    }
    
    public void conectar() throws SQLException {
        
        try {
            Class.forName(this.clase).newInstance();
            this.conector = DriverManager.getConnection(this.url, this.usuario, this.clave);
            this.conector.setTransactionIsolation(2);
            this.conector.setAutoCommit(false);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            
        }
        
    }
    public void desconectar() throws SQLException{
        if (!this.conector.isClosed()) {
            this.conector.close();
        }
    }

    public ResultSet consultar(String sql) throws SQLException {
        return new ResultSet(this.conector.createStatement().executeQuery(sql));
    }
    public String getDato(String sql, String nulo) throws SQLException {
        String salida = null;
        ResultSet rs = consultar(sql);
        if(rs.next()){
            salida = rs.getString(1);
        }
        if (salida == null) {
            return nulo;
        }
        return salida; 
    }
    public JsonArray getJsonArray(String sql) throws SQLException {
        ResultSet rs = consultar(sql);
        return rs.getJsonArray(); 
    }
    
    public void ejecutar(String sql) throws SQLException  {

        Statement sentencia = this.conector.createStatement();
        sentencia.execute(sql);
        comit();

    }
    public void ejecutar(String sql, boolean commit) throws SQLException{

        Statement sentencia = this.conector.createStatement();
        sentencia.execute(sql);
        if(commit){
            comit();
        }

    }
    
    public void comit() throws SQLException {
        
        try {
            this.conector.commit();
        } catch (SQLException ex) {
            this.conector.rollback();
        }
        
    }
    public void rollback() throws SQLException {
        
        try {
            this.conector.rollback();
        } catch (SQLException ex) {
            this.conector.rollback();
        }
        
    }
    
}