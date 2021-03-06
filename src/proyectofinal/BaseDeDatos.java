package proyectofinal;
/**
 *
 * @author Gerardo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseDeDatos {
    private String url = "jdbc:mysql://sql5.freemysqlhosting.net/";
    private Connection conexion;
    private boolean conectado;
    
    public BaseDeDatos() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean conectar(String nombre, String usuario, String contra) throws SQLException {
        if (!(nombre.isEmpty() && usuario.isEmpty())) {
            conexion = DriverManager.getConnection(url + nombre, usuario, contra);
            Statement s = conexion.createStatement();
            conectado = true;
        }
        return conectado;
    }
    public ResultSet cosultar(String consulta) throws SQLException{
        if (conectado) {
            return conexion.createStatement().executeQuery(consulta);
        } else {
            System.out.println("No se encuentra conectado");
            return null;
        }
    }
    public boolean modificar(String comando) throws SQLException {
        if (conectado) {
            return conexion.createStatement().execute(comando);
        } else {
            System.out.println("No se encuentra conectado");
            return false;
        }
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    public Object getCampo()  {
        return null;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
