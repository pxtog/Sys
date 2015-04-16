
package sys.util;

import java.util.ResourceBundle;
import sys.db.Conexion;

public final class Sistema {

    private final static ResourceBundle rb = ResourceBundle.getBundle("sys.config");

    public final static String empresaName = rb.getString("empresa.name");
    
    public final static String appName = rb.getString("system.app.name");
    public final static String appNameFull = rb.getString("system.app.name.full");
    
    public final static String appVersion = rb.getString("system.app.version");

    public final static Conexion global = new Conexion("system.app.db");

}
