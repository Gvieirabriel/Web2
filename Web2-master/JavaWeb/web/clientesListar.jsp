<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

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
            <h1>Lista de Clientes</h1>
            </br>
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center">  
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <% List<Cliente> list = (List<Cliente>) request.getAttribute("list"); %>
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                        <table class="table">
                            <thead>
                            <tr>
                              <th>CPF</th>
                              <th>Nome</th>
                              <th>Email</th>
                            </tr>
                            </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="item">
                                        <tr>
                                        <td>${item.cpfCliente}</td>
                                        <td>${item.nomeCliente}</td>
                                        <td>${item.emailCliente}</td>
                                        <td><a href="VisualizarClienteServlet?id=" onclick="location.href=this.href+${item.idCliente};return false;"><i class="glyphicon glyphicon-list-alt"></i></a></td>
                                        <td><a href="FormAlterarClienteServlet?id=" onclick="location.href=this.href+${item.idCliente};return false;"><i class="glyphicon glyphicon-pencil"></i></a></td>
                                        <td><a href="RemoverClienteServlet?id=" onclick="location.href=this.href+${item.idCliente};return false;"><i class="glyphicon glyphicon-remove"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                        </table>
                        <button onclick="window.location.href='FormNovoClienteServlet'">Novo Cliente</button>
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
