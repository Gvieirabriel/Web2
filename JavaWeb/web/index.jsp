<%-- 
    Document   : index
    Created on : 01/04/2018, 19:05:10
    Author     : gqueiroz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" errorPage="erro.jsp" pageEncoding="UTF-8"%>

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
                <p style='color: red'>
                    <c:if test = "${not empty param.msg}">  
                        <c:out value="${param.msg}"/>
                    </c:if>
                    <c:if test = "${not empty requestScope.msg}"> 
                        <c:out value="${requestScope.msg}"/>
                    </c:if>
                <p>
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
        <p>Em caso de problemas contactar o administrador:
            <c:out value = "${applicationScope.configuracao.adminEmail}"/></p>
    </footer>
</html>