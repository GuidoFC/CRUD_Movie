package principal.hellodia24.Importante.ModeloDAO;

import principal.hellodia24.Importante.Config.Conexion;
import principal.hellodia24.Importante.Interfaces.CRUD_User;
import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//DAO (Data Access Object) es un patrón de diseño que organiza el acceso a la base de datos en una clase específica.
//MovieDAO en tu aplicación se encarga de todas las operaciones relacionadas con la base de datos para las películas.
//Gracias a MovieDAO, otras partes de la aplicación pueden interactuar con los datos de las películas sin preocuparse de los detalles técnicos de la base de datos

public class UsuarioDAO implements CRUD_User {
    // realizar la conexion con la BD
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    @Override
    public void crearUsuarioBD(Usuario crearUsuario) {
        String sql = "INSERT INTO usuarios ( nombre, email, contrasena) VALUES ( ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, crearUsuario.getNombre());
            ps.setString(2, crearUsuario.getEmail());
            ps.setString(3, crearUsuario.getContrasena());

            // Ejecuta la inserción
            ps.executeUpdate();
            System.out.println("Usuario insertado correctamente en la base de datos.");

        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra los recursos (rs, ps, con) para evitar fugas de memoria
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Usuario getUserByID(int id) {
        return null;
    }

    @Override
    public void modificarUsuario(Movie updatedMovie) {

    }

    @Override
    public void eliminarUsuario(int id) {

    }

    @Override
    public int obtenerUltimoID() {
        // TODO no necesario porque mi Campo ID es AUTOINCREMENTAL

        int ultimoId = -5;
//        De esta forma tenemos el ultimo ID
        String sql = "SELECT MAX(id) AS max_id25 FROM usuarios";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getInt("max_id25");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos (rs, ps, con) para evitar fugas de memoria
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ultimoId;
    }


    public boolean existeEmailEnUsuarios(String email) {
// SELECT 1 -> si encuentra el email devolver 1
        String sql = "SELECT 1 FROM usuarios WHERE email = ?";
        boolean existe = false;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);  // Configura el email en el PreparedStatement
            rs = ps.executeQuery();

            // Si se obtiene algún resultado, significa que el email existe en la tabla
            if (rs.next()) {
                existe = true;
            }
        } catch (
                Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra los recursos (rs, ps, con) para evitar fugas de memoria
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return existe;
    }

    public Usuario getUsuarioPorEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contrasena")); // La contraseña ya está cifrada en la BD
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}

