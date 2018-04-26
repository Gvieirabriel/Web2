<%-- 
    Document   : erro
    Created on : 15/03/2018, 15:23:22
    Author     : gqueiroz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>J.D.I.</title>
    </head>
    <body>
        <h2>Mensagem de erro:</h2>
        <p><c:out value = "${exception.msg}"/></p>
        <p>
            <c:out value = "${pageContext.out.flush()}"/>
            <c:out value = "${exception.printStackTrace(pageContext.response.writer)}"/>
        </p>
        <p><a href=${page}>Clique aqui</a></p>
    </body>
    <footer class="container-fluid text-center">
        <p>Em caso de problemas contactar o administrador:
            <c:out value = "${applicationScope.configuracao.adminEmail}"/></p>
    </footer>
</html>
