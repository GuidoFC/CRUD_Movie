package principal.hellodia24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import principal.hellodia24.dao.MovieDao;
import principal.hellodia24.dao.MovieDaoImpl;
import principal.hellodia24.model.Movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// escucha las peticiones de /movies"
//  Indica que esta clase es un servlet y que responde a solicitudes enviadas a la URL /movies
@WebServlet(name = "movieServlet", value = "/movies")
// HttpServlet recibe peticiones web
public class MovieServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!!!!!!!";
    }

    //    doGet(): Este mé_todo se ejecuta cuando alguien visita /movies con una solicitud HTTP GET.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");: Configura el tipo de contenido de la respuesta como HTML.
        response.setContentType("text/html");
//        31/10
//        Movie movieDao = new MovieDaoImpl();
//        request.setAttribute("pelis", movieDao.findAll());
        try {
            request.getRequestDispatcher("movies.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


// 29/10
        // Hello
//        PrintWriter out = response.getWriter();: Crea un objeto PrintWriter para escribir en la respuesta.
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        // Obtener el parámetro id de la URL
        // http://localhost:8080/AppWeb24/movies?id=4
        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                MovieDao movieDao = new MovieDaoImpl();

                Movie movie = movieDao.findMovieById(id);

                if (movie != null) {
                    out.println("<h1>Detalle de la Película</h1>");
                    out.println("<p>" + movie + "</p>");
                } else {
                    out.println("<p>No se encontró la película con ID " + id + "</p>");
                }

            } catch (NumberFormatException e) {
                out.println("<p>ID inválido.</p>");
            }
        } else {
            out.println("<p>ID no proporcionado.</p>");
        }
//        Conexión a la Base de Datos
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Crea una conexión a la base de datos movies usando el usuario root y la contraseña root
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

//            statement.createStatement(): Crea un objeto para enviar consultas SQL.
            Statement statement = connection.createStatement();
//            String query = "select * from movies";: Define una consulta SQL para obtener todas las películas de la tabla movies
            String query = "select * from movies";
//            ResultSet result = ...: Ejecuta la consulta y almacena los resultados en result
            ResultSet result = statement.executeQuery(query);
// Crea una lista para almacenar las películas obtenidas.
            List<Movie> movies = new ArrayList<>();
//while (result.next()): Itera sobre cada fila de resultados
            while (result.next()) {
//                result.get...: Obtiene los valores de cada columna (id, title, description, year) para crear un objeto Movie
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");


                Movie movie = new Movie(id, title, description, year);

                movies.add(movie);
            }

            movies.forEach(movie -> {
//   PrintWriter out = response.getWriter();: Crea un objeto PrintWriter para escribir en la respuesta.
                out.println(movie + "<tr>");
            });

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//Cerrar el HTML
        out.println("</body></html>");
    }

    public void destroy() {
    }
}