
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private String url = "db/repaso.db";
    private Connection connect;

    public void Conectar() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado exitoso");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CerrarConexion() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUrl() {
        return url;
    }

    public Connection getConnect() {
        return connect;
    }
    
    

}