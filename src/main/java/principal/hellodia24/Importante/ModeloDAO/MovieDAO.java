package principal.hellodia24.Importante.ModeloDAO;

import principal.hellodia24.Importante.Config.Conexion;
import principal.hellodia24.Importante.Interfaces.CRUD;
import principal.hellodia24.Importante.Modelo.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements CRUD {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Movie movie = new Movie();


    @Override
    public List<Movie> listar() {
        ArrayList<Movie> list = new ArrayList<>();
        String sql = "select * from movies";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
//                result.get...: Obtiene los valores de cada columna (id, title, description, year) para crear un objeto Movie
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
    public boolean add(Movie movie) {
        return false;
    }

    @Override
    public boolean edit(Movie movie) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }
}
