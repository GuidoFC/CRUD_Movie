<%@ page import="principal.hellodia24.Importante.ModeloDAO.MovieDAO" %>
<%@ page import="principal.hellodia24.Importante.Modelo.Movie" %><%--
  Created by IntelliJ IDEA.
  User: Guido
  Date: 02/11/2024
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
</head>
<body>
<div >
    <div >
        <%
            MovieDAO dao = new MovieDAO();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            Movie p = (Movie) dao.list(id);
        %>
        <h1>Modificar Pelicula</h1>
        <form action="Controlador">
            Titulo:<br>
            <input type="text" name="txtDni" value="<%= p.getTitle()%>"><br>
            Descripcion: <br>
            <input  type="text" name="txtNom" value="<%= p.getDescription()%>"><br>

            <input type="hidden" name="txtid" value="<%= p.getId()%>">
            <input  type="submit" name="accion" value="Actualizar">
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </div>

</div>
</body>
</html>
