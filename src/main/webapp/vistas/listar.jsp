<%@ page import="principal.hellodia24.Importante.ModeloDAO.MovieDAO" %>
<%@ page import="principal.hellodia24.Importante.Modelo.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Guido
  Date: 02/11/2024
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Peliculas</h1>
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
        <%

            MovieDAO dao = new MovieDAO();
            List<Movie> list = dao.listar();
            Iterator<Movie> iter = list.iterator();
            Movie per = null;
            while (iter.hasNext()) {
                per = iter.next();

        %>
        <tbody>
        <tr>
            <td><%= per.getId()%>
            </td>
            <td><%= per.getTitle()%>
            </td>
            <td><%= per.getDescription()%>
            </td>
            <td><%= per.getYear()%>
            </td>
            <td>
                <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId()%>">Remove</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
