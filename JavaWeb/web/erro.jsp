<%-- 
    Document   : erro
    Created on : 15/03/2018, 15:23:22
    Author     : gqueiroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h2>Mensagem de erro:</h2>
        <p>${msg}</p>
        <p><a href=${page}>Clique aqui</a></p>
    </body>
    <footer
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>
