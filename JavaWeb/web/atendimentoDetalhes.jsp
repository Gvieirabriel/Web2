<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="java.util.List"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" errorPage="erro.jsp" pageEncoding="UTF-8"%>

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
              <li><a href="AtendimentoServlet?action=formNew">Efetuar Atendimento</a></li>
              <li><a href="AtendimentoServlet?action=list">Mostrar Atendimentos</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
            </ul>
          </div>
        </div>
        </nav>
        </br>
        <div class="container text-center"> 
            <h1>Detalhe de Atendimento</h1>
            </br>
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center">  
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                        <table class="table">
                            <thead>
                            <tr>
                              <th>Tipo Atendimento</th>
                              <th>Cliente</th>
                              <th>Produto</th>
                              <th>Descrição</th>
                              <th>Resposta</th>
                              <th>Data</th>
                            </tr>
                            </thead>
                                <tbody>
                                    <tr>
                                    <tr>
                                    <td><c:out value = "${tipoAtendimento}"/></td>
                                    <td><c:out value = "${cliente}"/></td>
                                    <td><c:out value = "${produto}"/></td>
                                    <fmt:formatDate value="${atendimento.dtHrAtendimento}"pattern="dd/MM/YYYY hh:mm" var="formateDate"/>
                                    <td><c:out value = "${atendimento.dscAtendimento}"/></td>
                                    <td><c:out value = "${atendimento.resAtendimento}"/></td>
                                    <td><c:out value = "${formateDate}"/></td>
                                    </tr>
                                </tbody>
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
        <p>Em caso de problemas contactar o administrador:
            <c:out value = "${applicationScope.configuracao.adminEmail}"/></p>
    </footer>
</html>
