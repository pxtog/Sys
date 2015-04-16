
package sys.util;

import javax.json.JsonArrayBuilder;

public class JsonArray {
    
    JsonArrayBuilder jsonArray;
    
    public JsonArray(){
        jsonArray = javax.json.Json.createArrayBuilder();
    }
    
    public javax.json.JsonArray build(){
        return this.jsonArray.build();
    }
    
    public JsonArray add(String value){
        jsonArray.add(value);
        return this;
    }
    public JsonArray add(int value){
        jsonArray.add(value);
        return this;
    }
    public JsonArray add(Float value){
        jsonArray.add(value);
        return this;
    }
    
    public JsonArray add(Json value){
        jsonArray.add(value.build());
        return this;
    }
    
    public String getString(){
        return jsonArray.build().toString();
    }
    
}
