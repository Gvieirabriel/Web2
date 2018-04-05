<%-- 
    Document   : clienteNovo
    Created on : 04/04/2018, 01:10:08
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Cadastro de Cliente</h1>
            <div class="col-sm-2 sidenav">
            </div>
            <div class="col-sm-8 text-center">
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}"> 
                        <form action="NovoClienteServlet" method="POST">
                        <table class="table">
                            <tr>
                              <th>Nome</th>
                              <td><input type="text" name="nomeCliente" required /></td>
                            </tr>
                            <tr>
                              <th>CPF</th>
                              <td><input type="text" name="cpfCliente" maxlength="11" required /></td>
                            </tr>
                            <tr>
                              <th>Email</th>
                              <td><input type="email" class="form-control" name="emailCliente" required /></td>
                            </tr>
                            <tr>
                              <th>CEP</th>
                              <td><input type="text" name="cepCliente" maxlength="8" required /></td>
                            </tr>
                            <tr>
                              <th>Rua</th>
                              <td><input type="text" name="ruaCliente" required /></td>
                            </tr>
                            <tr>
                              <th>Cidade</th>
                              <td><input type="text" name="cidadeCliente" required /></td>
                            </tr>
                            <tr>
                              <th>UF</th>
                              <td><input type="text" name="ufCliente" maxlength="2" required /></td>
                            </tr>
                            <tr>
                              <th>Número</th>
                              <td><input type="number" name="nrCliente" required /></td>
                            </tr>
                            <tr>
                              <th>Nascimento</th>
                              <td><input type="date" name="dateCliente" required /></td>
                            </tr>
                        </table>
                        <button type="submit" value="Ok">Salvar</button>
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
        <jsp:useBean id="configuracao" scope="application" class="com.ufpr.tads.web2.beans.ConfigBean" />
        <p>Em caso de problemas contactar o administrador: 
            <jsp:getProperty name="configuracao" property="adminEmail" /> </p>
    </footer>
</html>