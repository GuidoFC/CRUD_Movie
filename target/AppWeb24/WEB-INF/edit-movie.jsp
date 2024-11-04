<%@ page import="principal.hellodia24.Importante.Modelo.Movie" %><%--
  Created by IntelliJ IDEA.
  User: Guido
  Date: 04/11/2024
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="col-lg-6">
        <%

            Movie movie = (Movie) request.getAttribute("peliculaEncontrada");
        %>
        <h1>Editar Película</h1>
//        Llamamos al servlet y con el método Post para editar la pelicar
        <form action="movie?accion=actualizarPelicula" method="post">
            Título:<br>
            <input class="form-control" type="text" name="txtTitle" value="<%= movie.getTitle() %>"><br>

            Descripción: <br>
            <input class="form-control" type="text" name="txtDescription" value="<%= movie.getDescription() %>"><br>

            Año: <br>
            <input class="form-control" type="number" name="txtYear" value="<%= movie.getYear() %>"><br>

//            Escondemos el id de la pelicula para que el usuario no lo vea
            <input type="hidden" name="txtId" value="<%= movie.getId() %>">

            <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
            <a href="movie">Regresar al listado de peliculas</a>
        </form>
    </div>
</div>
</body>

</html>
