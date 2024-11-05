package principal.hellodia24.Importante.Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.Service.MovieService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//Esta es una anotación para decirle a Java que esta clase será un "Servlet".
// Un servlet es básicamente una pequeña aplicación que responde a solicitudes en la web.
@WebServlet(
//        Nombre del Servlet
        name = "MovieServlet",
        // indica que este servlet responderá cuando alguien visite la URL /movie en el servidor.
        urlPatterns = "/movie")

//
// Declara la clase MovieServlet, que extiende HttpServlet, lo que significa que esta clase puede manejar solicitudes HTTP, como GET o POST.
public class MovieServlet extends HttpServlet {
    private MovieService movieService = new MovieService();

//    Este méto_do doGet se ejecuta automáticamente cuando alguien hace una solicitud GET a la URL /movie
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("accion");

    if ("editar".equals(action)) {
        // TODO
        // 1 Obtener el ID de la película a editar
        // 2 Creo un formulario con los valores de la pelicula
        // 3 REcibir esos valores del formulario
        // 4 editarlo en la base de datos
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            request.setAttribute("peliculaEncontrada", movie.get());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/edit-movie.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("movie"); // Redirigir a la lista si la película no existe
        }
    } else if ("eliminar".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            movieService.removePeliculaById(id);
            response.sendRedirect("movie"); // Refrescamos la pantalla para ver todas las pelis sin la peli eliminada
        }
    } else if ("crearPelicula".equals(action)) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/crear-movie.jsp");
        dispatcher.forward(request, response);

    } else {
        processRequest(request, response); // Mostrar la lista de películas
    }
}

    // TODO porque tenemos que crear este método processRequest y no lo hacemos
    // direcamente desde el método doGet?
    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Movie> listaPeliculas = movieService.getListMovieFromService();
        //
        request.setAttribute("listaPeliculas", listaPeliculas);

//                    .ifPresent(s -> request.setAttribute("studentRecord", s));


        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/movie-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        if ("actualizarPelicula".equals(action)) {
            Long id = Long.valueOf(request.getParameter("txtId"));
            String title = request.getParameter("txtTitle");
            String description = request.getParameter("txtDescription");
            int year = Integer.parseInt(request.getParameter("txtYear"));

            Movie updatedMovie = new Movie(id, title, description, year);
            movieService.updateMovie(updatedMovie);

            response.sendRedirect("movie"); // Redirigir a la lista de películas
        } else if ("crearPeliculaNueva".equals(action)) {

            String title = request.getParameter("txtTitle");
            String description = request.getParameter("txtDescription");
            int year = Integer.parseInt(request.getParameter("txtYear"));

            Movie crearPelicula = new Movie(null, title, description, year);
            movieService.crearMovie(crearPelicula);
            response.sendRedirect("movie"); // Redirigir a la lista de películas
        }
    }


}
