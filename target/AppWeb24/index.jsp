<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Estamos en index.jsp" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div>

<%--    Creo que deberia ir al MovieSERVLET --%>
<%--    tengo q mirar el patron de diseño Interceptor--%>
    <a href="movie">Listar Peliculas</a>
    <br>
    <a href="usuario?accion=crearUsuarioNuevo">Crear un usuario</a>
    <br>
    <a href="usuario?accion=IniciarSesion">Iniciar Sesión</a>
    <br>
</div>
</body>
</html>
