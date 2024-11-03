<%@ page import="java.util.List" %>
<%@ page import="principal.hellodia24.Importante.Modelo.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Estoy en movie-record</h1>

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
            for (Movie per : listaPeliculas) {
    %>
    <tr>
        <td><%= per.getId() %></td>
        <td><%= per.getTitle() %></td>
        <td><%= per.getDescription() %></td>
        <td><%= per.getYear() %></td>
        <td>
            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId() %>">Editar</a>
            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId() %>">Remove</a>
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
