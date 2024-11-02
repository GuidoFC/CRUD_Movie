<%--31/10 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Lista de peliculas</h1>


<%--  "<%" Puedo poner codigo JAVA "%>"  --%>
<%--<p><% out.print():;%></p>--%>

<c:forEach var="peli" items="${pelis}">
    <p> <a href="movies?id=${peli.id}">  Title: ${peli.title} </a></p>
</c:for>

</body>
</html>
