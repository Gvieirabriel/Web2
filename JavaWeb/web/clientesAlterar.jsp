<%-- 
    Document   : clientesAlterar
    Created on : 04/04/2018, 00:05:50
    Author     : Pichau
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Atualização de Cliente</h1>
            <div class="col-sm-2 sidenav"></div>
            <div class="col-sm-8 text-center">
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}"> 
                        <form action="ClientesServlet?action=update" method="POST">
                        <table class="table">
                            <tr>
                              <th>Nome</th>
                              <td><input type="text" name="nomeCliente" value="${client.nomeCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>CPF</th>
                              <td><input type="text" name="cpfCliente" maxlength="11" value="${client.cpfCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Email</th>
                              <td><input type="email" name="emailCliente" value="${client.emailCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>CEP</th>
                              <td><input type="text" name="cepCliente" maxlength="8" value="${client.cepCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Rua</th>
                              <td><input type="text" name="ruaCliente" value="${client.ruaCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Cidade</th>
                              <td><input type="text" name="cidadeCliente" value="${client.cidadeCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>UF</th>
                              <td><input type="text" name="ufCliente" maxlength="2" value="${client.ufCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Número</th>
                              <td><input type="number" name="nrCliente" value="${client.nrCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Nascimento</th>
                              <fmt:formatDate value="${client.dataCliente}"pattern="YYYY-MM-dd" var="formateDate"/>
                              <td><input type="date" name="dateCliente" value="${formateDate}"/></td>
                            </tr>
                        </table>
                        <input type="hidden" name="idCliente" value="${client.idCliente}">
                        <button type="submit" value="Ok">Alterar</button>
                        <button onclick="window.location.href='ClientesServlet'">Cancelar</button>
                        </form>
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
