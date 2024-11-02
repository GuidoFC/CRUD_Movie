package principal.hellodia24.Importante.Config;

import java.sql.*;

public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Crea una conexión a la base de datos movies usando el usuario root y la contraseña root
            con = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
