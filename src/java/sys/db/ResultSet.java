
package sys.db;

import java.sql.SQLException;
import java.util.HashMap;
import sys.util.Json;
import sys.util.JsonArray;

public class ResultSet{

    public java.sql.ResultSet resultSet;

    public ResultSet(java.sql.ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public int getNumeroColumnas() throws SQLException{
        return resultSet.getMetaData().getColumnCount();
    }
    public String getNombreColumna(int indiceColumna)throws SQLException{ 
        return resultSet.getMetaData().getColumnName(indiceColumna);
    }
    public String getLabelColumna(int indiceColumna)throws SQLException{ 
        return resultSet.getMetaData().getColumnLabel(indiceColumna);
    }
    public String getTipoFila(int indiceColumna)throws SQLException{
        return resultSet.getMetaData().getColumnTypeName(indiceColumna);
    }
    
    public boolean next()throws SQLException{
        return resultSet.next();
    }
    public void close() throws SQLException{
        resultSet.close();
    }
    
    public Json getJsonRow() throws SQLException{
        Json json = new Json();       
        for(int i = 1 ; i<= resultSet.getMetaData().getColumnCount(); i++){
            json.add(this.getNombreColumna(i), resultSet.getObject(i));
        }
        return json;        
    }
    public JsonArray getJsonArray() throws SQLException{
        JsonArray jsonArray = new JsonArray();
        Json json;
        while(resultSet.next()){
            json = new Json();
            for(int i = 1 ; i<= resultSet.getMetaData().getColumnCount(); i++){
                json.add(this.getNombreColumna(i), resultSet.getObject(i));
            }
            jsonArray.add(json);
        }
        return jsonArray;
    }
    
    public Object getObject(String nombreColumna)throws SQLException{
        return resultSet.getObject(nombreColumna);
    }
    public Object getObject(int indiceColumna)throws SQLException{
        return resultSet.getObject(indiceColumna);
    }
    public Object getObject(String nombreColumna, String valorNulo)throws SQLException{
        return resultSet.getObject(nombreColumna) == null ? valorNulo:resultSet.getObject(nombreColumna);
    }
    public Object getObject(int indiceColumna, String valorNulo)throws SQLException{
        return resultSet.getObject(indiceColumna)==null?valorNulo:resultSet.getObject(indiceColumna);
    }

    public String getString(String nombreColumna,String valorNulo)throws SQLException{
        return resultSet.getObject(nombreColumna)==null?valorNulo:resultSet.getString(nombreColumna);
    }
    public String getString(int indiceColumna,String valorNulo)throws SQLException{
        return resultSet.getObject(indiceColumna)==null?valorNulo:resultSet.getString(indiceColumna);
    }
    public String getString(String nombreColumna)throws SQLException{
        return resultSet.getString(nombreColumna);
    }
    public String getString(int indiceColumna)throws SQLException{
        return resultSet.getString(indiceColumna);
    }

    public int getInt(String nombreColumna,Integer valorNulo)throws SQLException{
        return resultSet.getObject(nombreColumna)==null?valorNulo:resultSet.getInt(nombreColumna);
    }
    public int getInt(int indiceColumna,Integer valorNulo)throws SQLException{
        return resultSet.getObject(indiceColumna)==null?valorNulo:resultSet.getInt(indiceColumna);
    }
    public int getInt(String nombreColumna)throws SQLException{
        return resultSet.getInt(nombreColumna);
    }
    public int getInt(int indiceColumna)throws SQLException{
        return resultSet.getInt(indiceColumna);
    }

}