<%-- 
    Document   : portal
    Created on : 22/03/2018, 15:20:21
    Author     : gqueiroz
--%>

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
        <div class="text-center">
        <h2>Usuário logado</h2>
        <h3><c:out value = "${loginBean.nomeUsuario}"/></h3>
        </div>
        <div class="container text-left">

            <div class="col-sm-2 sidenav"></div>
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                    <p>
                            <h3>Relatorios:</h3>
                            <a href="ReportServlet?action=cliente"><button type="button">Gerar relatório de clientes</button></a></br>
                            <a href="ReportServlet?action=atendimentoResolvido"><button type="button">Gerar relatório de atendimentos resolvidos</button></a></br>
                            <form action='ReportServlet?action=atendimentoTipo' method="POST">
                                <button type="submit">Gerar relatório de atendimentos por tipo</button>
                                <select name="tipo" style="height:50px; width:160px">
                                    <c:forEach items="${tipos}" var="tipo">
                                        <option value="${tipo.idTipoAtendimento}">${tipo.nomeTipoAtendimento}</option>
                                    </c:forEach>
                                </select>
                            </form>
                            <form action='ReportServlet?action=atendimentoIntervalo' method="POST">
                                <button type="submit">Gerar relatório de atendimentos entre datas</button>
                                <input type="date" name="dateInicial" style="height:50px; width:160px"/>
                                <input type="date" name="dateFinal" style="height:50px; width:160px"/>
                            </form>
                    </p>
                    </c:when>
                    <c:otherwise>
                        <jsp:forward page="index.jsp">
                            <jsp:param name='msg' value='Usuário deve se autenticar para acessar o sistema!'/> 
                        </jsp:forward>
                    </c:otherwise>
                </c:choose>
            <div class="col-sm-2 sidenav"></div>
        </div>
    </body>
    <footer class="container-fluid text-center">
        <p>Em caso de problemas contactar o administrador:
            <c:out value = "${applicationScope.configuracao.adminEmail}"/></p>
    </footer>
</html>
