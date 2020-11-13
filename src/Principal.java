
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Principal {
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Conexion c = new Conexion();
            
            c.Conectar();
            
            
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            
            /*c.getConnect().createStatement().execute("INSERT INTO estudiante (id,nombre,correo) "
                    + "VALUES ( 3, 'Juan', 'juan@correo.com');");*/
            ResultSet resultado = c.getConnect().createStatement().executeQuery("SELECT * FROM estudiante;");
            while (resultado.next()) { //esultado.next() retorna un boolean; true si hay un siguiente.
                long id = Long.parseLong(resultado.getString(1));
                String nombre = resultado.getString(2);
                String correo = resultado.getString(3);
                
                Estudiante e = new Estudiante(id,nombre,correo);
                estudiantes.add(e);
            }
            
            for (Estudiante estudiante : estudiantes) {
                System.out.println("id: "+estudiante.getId()+" nombre: "+estudiante.getNombre()+ " "
                        + "correo: "+estudiante.getCorreo());
            }

            c.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}