// package donde se encuentra esta clase
package principal.hellodia24.Importante.Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.ModeloDAO.MovieDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/add.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("accion");

        if ("listar".equalsIgnoreCase(action)) {
            MovieDAO movieDAO = new MovieDAO();
            List<Movie> listaPeliculas = movieDAO.listar(); // Método que devuelve la lista de películas
            request.setAttribute("listaPeliculas", listaPeliculas);
            RequestDispatcher vista = request.getRequestDispatcher(listar);
            try {
                vista.forward(request, response);
            } catch (jakarta.servlet.ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
