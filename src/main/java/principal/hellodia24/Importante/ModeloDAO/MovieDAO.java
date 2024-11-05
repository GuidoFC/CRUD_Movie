package principal.hellodia24.Importante.ModeloDAO;

import principal.hellodia24.Importante.Config.Conexion;
import principal.hellodia24.Importante.Interfaces.CRUD_Movie;
import principal.hellodia24.Importante.Modelo.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO (Data Access Object) es un patrón de diseño que organiza el acceso a la base de datos en una clase específica.
//MovieDAO en tu aplicación se encarga de todas las operaciones relacionadas con la base de datos para las películas.
//Gracias a MovieDAO, otras partes de la aplicación pueden interactuar con los datos de las películas sin preocuparse de los detalles técnicos de la base de datos

public class MovieDAO implements CRUD_Movie {
    // realizar la conexion con la BD
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Movie movie = new Movie();


    @Override
    public List<Movie> getAllMovieFromBD() {
        ArrayList<Movie> list = new ArrayList<>();
        String sql = "select * from movies";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
//   result.get...: Obtiene los valores de cada columna (id, title, description, year) para crear un objeto Movie
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int year = rs.getInt("year");


                Movie movie = new Movie(id, title, description, year);

                list.add(movie);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Movie list(int id) {
        return null;
    }






    @Override
    public Movie getMovieByID(Long id) {
        Movie movie = null;
        String sql = "SELECT * FROM movies WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id); // Configura el valor del parámetro `id` en la consulta
            rs = ps.executeQuery();

            if (rs.next()) {
                // Obtiene los valores de cada columna para crear el objeto Movie
                Long movieId = rs.getLong("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int year = rs.getInt("year");

                // Crea una instancia de Movie con los valores obtenidos
                movie = new Movie(movieId, title, description, year);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra recursos (rs, ps, con) aquí si es necesario para evitar fugas de memoria
        }
        return movie;
    }




    public void modificarPelicula(Movie movie) {

        String sql = "UPDATE movies SET title = ?, description = ?, year = ? WHERE id = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, movie.getTitle());       // Configura el nuevo título
            ps.setString(2, movie.getDescription());  // Configura la nueva descripción
            ps.setInt(3, movie.getYear());            // Configura el nuevo año
            ps.setLong(4, movie.getId());             // Configura el ID para especificar la película a actualizar

            // Ejecuta la actualización y comprueba si se actualizaron filas
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra recursos (rs, ps, con) aquí si es necesario para evitar fugas de memoria
        }

    }

    @Override
    public void eliminarPeliculaByID(Long id) {
        String sql = "DELETE FROM movies WHERE id = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id); // Configura el ID de la película a eliminar

            // Ejecuta la eliminación
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra recursos (rs, ps, con) aquí si es necesario para evitar fugas de memoria
        }
    }

    @Override
    public Long obtenerUltimoID() {
        Long ultimoId = null;
//        De esta forma tenemos el ultimo ID
        String sql = "SELECT MAX(id) AS max_id25 FROM movies";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getLong("max_id25");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos (rs, ps, con) para evitar fugas de memoria
        }
        return ultimoId;
    }

    @Override
    public void crearPelicula(Movie crearPelicula) {
        String sql = "INSERT INTO movies (id, title, description, year) VALUES (?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, crearPelicula.getId());
            ps.setString(2, crearPelicula.getTitle());        // Configura el título
            ps.setString(3, crearPelicula.getDescription());   // Configura la descripción
            ps.setInt(4, crearPelicula.getYear());             // Configura el año

            // Ejecuta la inserción
            ps.executeUpdate();
            System.out.println("Película insertada correctamente en la base de datos.");

        } catch (Exception e) {
            e.printStackTrace(); // Muestra el error en la consola si ocurre una excepción
        } finally {
            // Cierra los recursos (ps, con) para evitar fugas de memoria
        }
    }


}
