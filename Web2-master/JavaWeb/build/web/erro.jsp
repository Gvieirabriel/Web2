<%-- 
    Document   : erro
    Created on : 15/03/2018, 15:23:22
    Author     : gqueiroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>J.D.I.</title>
    </head>
    <body>
        <h2>Mensagem de erro:</h2>
        <p>${msg}</p>
        <p><a href=${page}>Clique aqui</a></p>
    </body>
    <footer class="container-fluid text-center">
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>
