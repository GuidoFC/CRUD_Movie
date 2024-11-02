// package donde se encuentra esta clase
package principal.hellodia24;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// Un servlet en Maven es simplemente una clase en Java que actúa como "intermediario" entre el navegador y el servidor
// escucha las peticiones de /hello-servlet"
//La URL que activará este servlet (/http://localhost:8080/AppWeb24/movies)
@WebServlet(name = "helloServlet", value = "/hello-servlet")
// HttpServlet recibe peticiones web
// Declara la clase HelloServlet que extiende HttpServlet,
// lo cual le permite manejar peticiones HTTP y
// xresponde con contenido HTTP (en este caso, HTML).
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!!! Prueba";
    }

    //    HttpServletRequest request: contiene la información de la solicitud del cliente, como los parámetros que haya enviado en la URL o detalles de la conexión.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Mi url
//        http://localhost:8080/AppWeb24/hello-servlet?nombre=Guido
        // Obtener el parámetro "nombre" de la URL
        String nombre = request.getParameter("nombre");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + " " + nombre + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}