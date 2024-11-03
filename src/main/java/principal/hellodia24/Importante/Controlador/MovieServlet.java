package principal.hellodia24.Importante.Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.Modelo.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "MovieServlet",
        urlPatterns = "/movie")
public class MovieServlet extends HttpServlet {
    private MovieService movieService = new MovieService();

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Movie> listaPeliculas = movieService.getListMovie();
        //
        request.setAttribute("listaPeliculas", listaPeliculas);

//                    .ifPresent(s -> request.setAttribute("studentRecord", s));


        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/movie-record.jsp");
        dispatcher.forward(request, response);
    }
}
