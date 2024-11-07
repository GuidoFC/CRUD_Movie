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

//Esta es una anotación para decirle a Java que esta clase será un "Servlet".
// Un servlet es básicamente una pequeña aplicación que responde a solicitudes en la web.
@WebServlet(
//        Nombre del Servlet
        name = "MovieServlet",
        // indica que este servlet responderá cuando alguien visite la URL /movie en el servidor.
        urlPatterns = "/litarTodasPeliculas")

//
// Declara la clase MovieServlet, que extiende HttpServlet, lo que significa que esta clase puede manejar solicitudes HTTP, como GET o POST.
public class MovieServletListar extends HttpServlet {
    private MovieService movieService = new MovieService();

    //    Este méto_do doGet se ejecuta automáticamente cuando alguien hace una solicitud GET a la URL /movie
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        System.out.println("Estoy en MovieSerlet Listar doGet");

        processRequest(request, response); // Mostrar la lista de películas

    }

    // TODO porque tenemos que crear este método processRequest y no lo hacemos
    // direcamente desde el método doGet?
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Movie> listaPeliculas = movieService.getListMovieFromService();
        //
        request.setAttribute("listaPeliculas", listaPeliculas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/movie-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");

    }


}
