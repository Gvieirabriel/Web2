<%-- 
    Document   : index
    Created on : 01/04/2018, 19:05:10
    Author     : Pichau
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
        <div class="container text-center"> 
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center"> 
                <p style='color: red'>${msg}<p>
                <form action="LoginServlet" method="POST">
                    <label for="uname"><b>Login</b></label>
                    <input type="text" name="login" value=""/><br/>
                    <label for="psw"><b>Senha</b></label>
                    <input type="password" name="senha" value=""/><br/>
                    <button type="submit" value="Ok">Entrar</button>
                </form>
            </div>
            <div class="col-sm-2 sidenav"></div>
        </div>
    </body>
    <footer class="container-fluid text-center">
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>