<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

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
            </br>
            <h1>Detalhes do Cliente</h1>
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center">  
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                        <table class="table">
                            <tr>
                              <th>Nome</th>
                              <td><p><c:out value = "${client.nomeCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>CPF</th>
                              <td><p><c:out value = "${client.cpfCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>Email</th>
                              <td><p><c:out value = "${client.emailCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>CEP</th>
                              <td><p><c:out value = "${client.cepCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>Rua</th>
                              <td><p><c:out value = "${client.ruaCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>Cidade</th>
                              <td><p><c:out value = "${client.cidadeCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>UF</th>
                              <td><p><c:out value = "${client.ufCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>NR</th>
                              <td><p><c:out value = "${client.nrCliente}"/></p></td>
                            </tr>
                            <tr>
                              <th>Nascimento</th>
                              <td>
                                <p>
                                    <fmt:formatDate value="${client.dataCliente}"pattern="dd/MM/YYYY" var="formateDate"/>
                                    <c:out value = "${formateDate}"/>
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
        <p>Em caso de problemas contactar o administrador:
            <c:out value = "${applicationScope.configuracao.adminEmail}"/></p>
    </footer>
</html>
