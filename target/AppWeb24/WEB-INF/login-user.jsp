<%@ page import="principal.hellodia24.Importante.Modelo.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Guido
  Date: 04/11/2024
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Usuario</title>
</head>
<body>
<div class="container">
    <div class="col-lg-6">

        <h1>Iniciar Sesión</h1>

        <!-- Mostrar mensaje de error si existe -->
        <%
            String errorMessage = (String) request.getAttribute("error204");
            if (errorMessage != null) {
        %>
        <div style="color: red;">
            <%= errorMessage %>
        </div>
        <%
            }
        %>

        <form action="usuario?accion=IniciarSesion" method="post">
            Introduce tu Email:<br/>
            <input
                    class="form-control"
                    type="email"
                    name="txtEmail"
                    required
            /><br/>

            Introduce tu Contraseña:<br/>
            <input
                    class="form-control"
                    type="password"
                    name="txtPassword"
                    required
            /><br/>

            <input
                    class="btn btn-primary"
                    type="submit"
                    name="accion"
                    value="Iniciar Sesion"
            />
            <br/>
            <br/>
            <a href="mo">Regresar al index</a>
        </form>
    </div>
</div>
</body>

</html>
