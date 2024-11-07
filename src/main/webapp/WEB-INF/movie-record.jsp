<%@ page import="java.util.List" %>
<%@ page import="principal.hellodia24.Importante.Modelo.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Estoy en movie-record!!</h1>
<a href="crear?accion=crearPelicula">Añadir película</a>
<br>
<br>

<!-- Mostrar mensaje de error si existe de Email-->

<%
    String name = (String) request.getSession().getAttribute("name");
    String email = (String) request.getSession().getAttribute("email");


    if (name != null) {
%>
<div style="color: blue;">
    <p>Nombre:  <%= name %>
    </p>
    <p>Email: <%= email %>
    </p>

</div>
<div>
    <a href="cerrarSesion"> Cerrar Session</a>
    <br>
    <br>

</div>
<%
    }
%>
<br>
<br>
<a href="/AppWeb24">Regresar al index</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Titulo</th>
        <th>Descripcion</th>
        <th>Año</th>
        <th>ACCIONES</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (request.getAttribute("listaPeliculas") != null) {
            List<Movie> listaPeliculas = (List<Movie>) request.getAttribute("listaPeliculas");
            for (Movie movie : listaPeliculas) {
    %>
    <tr>
        <td><%= movie.getId() %>
        </td>
        <td><%= movie.getTitle() %>
        </td>
        <td><%= movie.getDescription() %>
        </td>
        <td><%= movie.getYear() %>
        </td>
        <td>
            <a href="editar?accion=editarPelicula&id=<%= movie.getId() %>">Editar</a>

            <a href="eliminar?id=<%= movie.getId() %>">Remove</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

</body>
</html>
