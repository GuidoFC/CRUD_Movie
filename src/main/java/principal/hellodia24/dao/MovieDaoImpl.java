package principal.hellodia24.dao;

import jakarta.servlet.http.HttpServlet;
import principal.hellodia24.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {


    List<Movie> movies = new ArrayList<>();

    public MovieDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            Statement statement = connection.createStatement();
            String query = "select * from movies";
            ResultSet result = statement.executeQuery(query);


            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");


                Movie movie = new Movie(id, title, description, year);

                this.movies.add(movie);
            }

            movies.forEach(movie -> {
//                out.println(movie + "<tr>");
            });

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movie> getMovies() {

        return movies;

    }

    @Override
    public Movie findMovieById(Long id) {

        Movie movie = null;
        try {
            // Conectar a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            // Crear consulta con parámetro id
            String query = "SELECT * FROM movies WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id); // Establece el valor del id en la consulta

            // Ejecutar la consulta
            ResultSet result = preparedStatement.executeQuery();

            // Si existe un resultado, crear el objeto Movie
            if (result.next()) {
                Long movieId = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");

                movie = new Movie(movieId, title, description, year);
            }

            // Cerrar conexión y recursos
            result.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

}

