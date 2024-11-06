package principal.hellodia24.Importante.Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import principal.hellodia24.Importante.Modelo.Usuario;

import principal.hellodia24.Importante.Service.UsuarioService;

import java.io.IOException;

@WebServlet(
        name = "crearUsuarioServlet",
        urlPatterns = "/usuario"
)
public class UsuarioServlet extends HttpServlet {
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Muestra el formulario para crear usuario
        String action = request.getParameter("accion");

        if ("IniciarSesion".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/login-user.jsp");
            dispatcher.forward(request, response);
        } else if ("crearUsuarioNuevo".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/create-user.jsp");
            dispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        if ("FormulariocrearUsuario".equals(action)) {
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            Usuario usuario = new Usuario();

            usuario.setNombre(name);
            usuario.setEmail(email);
            // cirframos la contraseña
            String contrasenaCifrada = UsuarioService.hashPassword(password);
            usuario.setContrasena(contrasenaCifrada); // Asegúrate de cifrar la contraseña antes de guardarla

            int ultimoid = usuarioService.crearUsuario(usuario);
            // Guarda los datos en la sesión en lugar de la solicitud
            // de esta forma los datos
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("email", email);


            response.sendRedirect("movie"); // Redirige al listado de Peliculas
        } else if ("IniciarSesion".equals(action)) {
            // cogemos los 2 parametros
            String email = request.getParameter("txtEmail");
            String contrasenaSinCifrar = request.getParameter("txtPassword");

            // comprobamos si existe el email
            if(!UsuarioService.existeEmail(email)){
            // Si el email no existe, añadimos un mensaje de error al request
                // es una llave valor: la llave es "error204"
                request.setAttribute("errorEmail", "El correo ingresado no es correcto. Intente de nuevo.");

                // Reenviamos la solicitud a login-user.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login-user.jsp");
                dispatcher.forward(request, response);
            }



            // comprobamos si la contraseña es correcta
            String contrasenaCifrada = UsuarioService.hashPassword(contrasenaSinCifrar);
            if(!UsuarioService.checkPassword(contrasenaSinCifrar, contrasenaCifrada)){
                request.setAttribute("errorContra", "La contraseña no es correcta. Intente de nuevo.");

                // Reenviamos la solicitud a login-user.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login-user.jsp");
                dispatcher.forward(request, response);

            }
            // if tod_o es correcto necesitamos el email y nombre
//            Usuario usuario = new Usuario();
//            usuario.setEmail(email);
//            usuario.setContrasena(contrasenaCifrada);

            // Si el usuario existe Redirige al listado de Peliculas
//            response.sendRedirect("movie");

        }
    }
}
