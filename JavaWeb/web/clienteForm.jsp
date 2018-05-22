<%-- 
    Document   : clienteNovo
    Created on : 04/04/2018, 01:10:08
    Author     : Gabriel
--%>

<%@page contentType="text/html" errorPage="erro.jsp" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.0.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    
    <script type="text/javascript" >

                        $("#cpf").mask("000.000.000-00",{reverse:true})
                        
                        $("#cep").mask("00000-000",{reverse:true});


                        $(document).ready(function() {
                            $( "#estado" ).change(function() {
                              getCidades();
                            });
                            if($("#cityCliente").val() != null)
                            {
                                $("#cidade").append('<option value=' + $("#cityCliente").val() + '>' + $("#cityCliente").val() + '</option>');  
                            }
                        });

                        function getCidades(){
                            var estadoId = $("#estado").val();
                            var url = "AjaxServlet";
                            $.ajax({
                                    url : url, // URL da sua Servlet
                                    data : {
                                        estadoId : estadoId
                                    }, // Parâmetro passado para a Servlet
                                    dataType : 'json',
                                    success : function(data) {
                                        console.log(estadoId);
                                        // Se sucesso, limpa e preenche a combo de cidade
                                        // alert(JSON.stringify(data));
                                        $("#cidade").empty();
                                        $.each(data, function(i, obj) {
                                            $("#cidade").append('<option value=' + obj.idCidade + '>' + obj.nomeCidade + '</option>');  
                                        });
                                    },
                                    error : function(request, textStatus, errorThrown) {
                                        alert(request.status + ', Error: ' + request.statusText);
                                         // Erro
                                    }
                                });
                        }
    </script>
    
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
            <h1>Cadastro de Cliente</h1>
            <div class="col-sm-2 sidenav">
            </div>
            <div class="col-sm-8 text-center">
                <jsp:useBean id="loginBean" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <c:choose>
                    <c:when test = "${not empty loginBean.nomeUsuario}">
                        <c:choose>
                            <c:when test = "${form eq 'alterar'}">
                                <c:set var = "formLink" value = "update"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var = "formLink" value = "new"/>
                            </c:otherwise>
                        </c:choose>
                        
                        <form id="form" action='ClientesServlet?action=${formLink}' method="POST">
                        <table class="table">
                            <tr>
                              <th>Nome</th>
                              <td><input type="text" name="nomeCliente" value="${client.nomeCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>CPF</th>
                              <td><input id="cpf" type="text" name="cpfCliente" maxlength="14" value="${client.cpfCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Email</th>
                              <td><input type="email" name="emailCliente" value="${client.emailCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>CEP</th>
                              <td><input type="text" name="cepCliente" maxlength="9" value="${client.cepCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Rua</th>
                              <td><input type="text" name="ruaCliente" value="${client.ruaCliente}" required /></td>
                            </tr>
                            <tr>
                              <th>Estado</th>
                              <td>
                                <select id="estado" name="estado" form="form">  
                                    <c:forEach var="elemento" items="${estados}">
                                        <c:choose>
                                            <c:when test = "${client.ufCliente eq elemento.idEstado}">
                                                <option default value="${elemento.idEstado}">${elemento.nomeEstado}</option>  
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${elemento.idEstado}">${elemento.nomeEstado}</option>  
                                            </c:otherwise>   
                                        </c:choose> 
                                    </c:forEach>  
                                </select>
                              </td>
                            </tr>
                            <tr>
                              <th>Cidade</th>
                              <td>
                                <select id="cidade" name="cidade" form="form"> 
                                </select>
                              </td>
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
                        
                        <c:choose>
                            <c:when test = "${form eq 'alterar'}">
                                <input type="hidden" name="idCliente" value="${client.idCliente}">
                                <input id="cityCliente" type="hidden" name="cityCliente" value="${cidadeCliente.nomeCidade}">
                                <button type="submit" value="Ok">Alterar</button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" value="Ok">Salvar</button>
                            </c:otherwise>
                        </c:choose>
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