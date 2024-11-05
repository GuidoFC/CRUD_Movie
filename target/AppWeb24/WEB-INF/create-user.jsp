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

        <h1>Crear un Usuario</h1>



        <form action="usuario?accion=crearUsuarioNuevo" method="post">
            Nombre:<br>
            <input class="form-control" type="text" name="txtName" required><br>

            Email:<br>
            <input class="form-control" type="email" name="txtEmail" required><br>

            Contraseña:<br>
            <input class="form-control" type="password" name="txtPassword" required><br>

            <input class="btn btn-primary" type="submit" name="accion" value="crear">
            <a href="mo">Regresar al index</a>
        </form>
    </div>
</div>
</body>

</html>
