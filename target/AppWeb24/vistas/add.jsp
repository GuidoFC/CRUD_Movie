<%--
  Created by IntelliJ IDEA.
  User: Guido
  Date: 02/11/2024
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
</head>
<body>
<div>
    <div>
        <h1>Agregar Pelicula</h1>
        <form action="Controlador">
            Titulo:<br>
            <input  type="text" name="Titulo"><br>
            Descripcion: <br>
            <input  type="text" name="Descripcion"><br>
            Año:<br>
            <input  type="text" name="ano"><br>
            <input type="submit" name="accion" value="Agregar">
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </div>

</div>
</body>
</html>

