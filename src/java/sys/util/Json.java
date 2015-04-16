
package sys.util;

import java.math.BigDecimal;
import javax.json.JsonObjectBuilder;
import javax.json.JsonObject;

public class Json {
    
    JsonObjectBuilder json;
    
    public Json(){
        json = javax.json.Json.createObjectBuilder();
    }
 
    public JsonObject build(){
        
        return this.json.build();
    }
    
    public Json add(String key, String value){
        json.add(key, value);
        return this;
    }
    public Json add(String key, Object value){
        
        if(value instanceof Integer){
            json.add(key, (Integer) value);
        }else if(value instanceof Double){
            json.add(key, (Double) value);
        }else if(value instanceof BigDecimal){
            json.add(key, (BigDecimal) value);
        }else{
              
            if(value == null){
                json.addNull(key);
            }else{  
                json.add(key, value.toString());
            }

        }
        
        return this;
    }
    public Json add(String key, int value){
        json.add(key, value);
        return this;
    }
    public Json add(String key, Json value){
        this.json.add(key, value.build());
        return this;
    }
    public String getString(){
        return json.build().toString();
    }

}
