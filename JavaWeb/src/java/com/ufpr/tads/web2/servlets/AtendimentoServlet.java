/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.LoginFacade;
import com.ufpr.tads.web2.facade.impl.DefaultAtendimentoFacade;
import com.ufpr.tads.web2.facade.impl.DefaultClientesFacade;
import com.ufpr.tads.web2.facade.impl.DefaultLoginFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gqueiroz
 */
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

    private HttpSession session;
    private RequestDispatcher rd;
    private ClientesFacade clientesFacade;
    private AtendimentoFacade atendimentoFacade;
    private LoginFacade loginFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();

        atendimentoFacade = new DefaultAtendimentoFacade();
        clientesFacade = new DefaultClientesFacade();
        loginFacade = new DefaultLoginFacade();

        LoginBean login = (LoginBean) session.getAttribute("loginBean");
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        if (login == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            rd.forward(request, response);
        }

        String action = request.getParameter("action");
        String url = "/atendimentoListar.jsp";

        if (action == null || action.isEmpty() || action.equals("list")) {

            List<Atendimento> atendimentos = atendimentoFacade.buscarTodos(login.getLoginUsuario());
            List<String> produtos = new ArrayList<String>();
            List<String> clientes = new ArrayList<String>();

            for (Atendimento a : atendimentos) {
                String p = atendimentoFacade.buscarProduto(a.getIdProduto()).getNomeProduto();
                String c = clientesFacade.buscar(Integer.toString(a.getIdCliente())).getNomeCliente();
                produtos.add(p);
                clientes.add(c);
            }

            request.setAttribute("atendimentos", atendimentos);
            request.setAttribute("produtos", produtos);
            request.setAttribute("clientes", clientes);

            url = "/atendimentoListar.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if (action.equals("show")) {
            final String id = request.getParameter("id");
            Atendimento atendimento = atendimentoFacade.buscar(Integer.parseInt(id));
            String produto = atendimentoFacade.buscarProduto(atendimento.getIdProduto()).getNomeProduto();
            String tipoAtendimento = atendimentoFacade.buscarTipoAtendimento(atendimento.getIdTipoAtendimento()).getNomeTipoAtendimento();
            String cliente = clientesFacade.buscar(Integer.toString(atendimento.getIdCliente())).getNomeCliente();

            request.setAttribute("atendimento", atendimento);
            request.setAttribute("produto", produto);
            request.setAttribute("cliente", cliente);
            request.setAttribute("tipoAtendimento", tipoAtendimento);

            url = "/atendimentoDetalhes.jsp";

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if (action.equals("formNew")) {
            url = "/atendimento.jsp";
            List<Produto> produtos = atendimentoFacade.buscarTodosProdutos();
            request.setAttribute("produtos", produtos);

            List<TipoAtendimento> tipos = atendimentoFacade.buscarTodosTipoAtendimento();
            request.setAttribute("tipos", tipos);

            List<Cliente> clientes = clientesFacade.buscarTodos();
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher(url);
            request.setAttribute("dataHora", new Date());
            rd.forward(request, response);
        } if(action.equals("save")) {
            try {
                url = "/atendimentoListar.jsp";
                Atendimento atendimento = new Atendimento();
                atendimento.setDtHrAtendimento(format.parse(request.getParameter("data")));
                atendimento.setDscAtendimento(request.getParameter("descricao"));
                atendimento.setIdCliente(Integer.parseInt(request.getParameter("cliente")));
                atendimento.setIdProduto(Integer.parseInt(request.getParameter("produto")));
                atendimento.setIdTipoAtendimento(Integer.parseInt(request.getParameter("tipo")));
                atendimento.setResAtendimento(request.getParameter("res").charAt(0));
                atendimento.setIdUsuario(loginFacade.buscarUsuario(login.getLoginUsuario()).getIdPessoa());
                atendimentoFacade.inserir(atendimento);
                response.sendRedirect("AtendimentoServlet");
            } catch (ParseException ex) {
                Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
