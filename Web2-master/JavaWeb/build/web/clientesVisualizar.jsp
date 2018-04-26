<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>J.D.I.</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="portal.jsp">Portal</a>
          </div>
          <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
              <li><a href="ClientesServlet">Clientes</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
            </ul>
          </div>
        </div>
        </nav>
        </br>
        <div class="container text-center"> 
            </br>
            <h1>Detalhes do Cliente</h1>
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center">  
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <% Cliente client = (Cliente) request.getAttribute("client"); %>
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                        <table class="table">
                            <tr>
                              <th>Nome</th>
                              <td><p>${client.nomeCliente}</p></td>
                            </tr>
                            <tr>
                              <th>CPF</th>
                              <td><p>${client.cpfCliente}</p></td>
                            </tr>
                            <tr>
                              <th>Email</th>
                              <td><p>${client.emailCliente}</p></td>
                            </tr>
                            <tr>
                              <th>CEP</th>
                              <td><p>${client.cepCliente}</p></td>
                            </tr>
                            <tr>
                              <th>Rua</th>
                              <td><p>${client.ruaCliente}</p></td>
                            </tr>
                            <tr>
                              <th>Cidade</th>
                              <td><p>${client.cidadeCliente}</p></td>
                            </tr>
                            <tr>
                              <th>UF</th>
                              <td><p>${client.ufCliente}</p></td>
                            </tr>
                            <tr>
                              <th>NR</th>
                              <td><p>${client.nrCliente}</p></td>
                            </tr>
                            <tr>
                              <th>Nascimento</th>
                              <td>
                                <p>
                                   <%DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");%>
                                   <%=formatter.format(client.getDataCliente()) %>
                                </p>
                              </td>
                            </tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <jsp:forward page="index.jsp">
                            <jsp:param name='msg' value='Usuário deve se autenticar para acessar o sistema!'/> 
                        </jsp:forward>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
    <footer class="container-fluid text-center">
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>
