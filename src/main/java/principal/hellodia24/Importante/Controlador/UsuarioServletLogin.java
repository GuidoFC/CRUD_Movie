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
        name = "UsuarioServletLogin",
        urlPatterns = "/usuarioLogin"
)
public class UsuarioServletLogin extends HttpServlet {
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accion");

        if ("IniciarSesion".equals(action)) {
            // Muestra el formulario para iniciar sesion
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/login-user.jsp");
            dispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

         if ("IniciarSesion".equals(action)) {
            // Obtenemos los parámetros del formulario de inicio de sesión
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

                // Guarda los datos en la sesión en lugar de la solicitud
                // de esta forma los datos
                request.getSession().setAttribute("email", email);

                return; // Terminamos la ejecución
            }

            // Obtenemos al usuario de la base de datos para comprobar la contraseña
            Usuario usuario = UsuarioService.obtenerUsuarioPorEmail(email);

            // Comprobamos si la contraseña es correcta usando BCrypt
            // tenemos que coger la contraseña que esta en la base de datos!!!!
            if (!UsuarioService.checkPassword(contrasenaSinCifrar, usuario.getContrasena())) {
                request.setAttribute("errorContra", "La contraseña no es correcta. Intente de nuevo.");

                // Reenviamos la solicitud a login-user.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login-user.jsp");
                dispatcher.forward(request, response);
                return; // Terminamos la ejecución
            }

            // Si to_do es correcto, guardamos la información del usuario en la sesión
            request.getSession().setAttribute("name", usuario.getNombre());
            request.getSession().setAttribute("email", usuario.getEmail());
            request.getSession().setAttribute("contrasena", usuario.getContrasena());

            // Redirigimos al listado de Peliculas
            response.sendRedirect("litarTodasPeliculas");


        }
    }
}
