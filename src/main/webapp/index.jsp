<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Estamos en index.jsp" %>
</h1>
<br/>

<div>

    <%--    Creo que deberia ir al MovieSERVLET --%>
    <%--    tengo q mirar el patron de diseño Interceptor--%>
    <br>
    <a href="movie">Listar Peliculas</a>
    <br>
    <br>
    <a href="usuario?accion=crearUsuarioNuevo">Crear un usuario</a>
    <br>
    <br>
    <a href="movie?accion=IniciarSesion">Iniciar Sesión</a>
    <br>
    <br>
</div>
</body>
</html>
