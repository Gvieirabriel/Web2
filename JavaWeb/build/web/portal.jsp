<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
        <c:choose>
            <c:when test = "${not empty loginBean.nomeUsuario}">
                <p>Usuário logado: ${loginBean.nomeUsuario}</p>
                <p><a href="LogoutServlet">Logout</a></p>
            </c:when>
            <c:otherwise>
                <jsp:forward page="erro.jsp">
                    <jsp:param name='msg' value='Usuário não logado!'/> 
                    <jsp:param name='page' value='/index.html' />
                </jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
    <footer
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>
