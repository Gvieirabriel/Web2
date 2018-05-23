/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.facade.CidadeFacade;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.EstadoFacade;
import com.ufpr.tads.web2.facade.impl.DefaultCidadeFacade;
import com.ufpr.tads.web2.facade.impl.DefaultClientesFacade;
import com.ufpr.tads.web2.facade.impl.DefaultEstadoFacade;
import com.ufpr.tads.web2.strategies.ValidaCPFStrategy;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author GQueiroz
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {
    private HttpSession session;
    private RequestDispatcher rd;
    private ClientesFacade clientesFacade;
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
        clientesFacade = new DefaultClientesFacade();
        LoginBean login = (LoginBean) session.getAttribute("loginBean");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String action = request.getParameter("action");
        EstadoFacade estadoFacade;
        CidadeFacade cidadeFacade;
        ValidaCPFStrategy valida = new ValidaCPFStrategy();
        if(action == null)
            action = "list";
        
        if (login == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            switch (action) {
                case "show":
                    rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");
                    request.setAttribute("client", clientesFacade.buscar(request.getParameter("id")));
                    rd.forward(request, response);
                    break;
                case "formUpdate":
                    estadoFacade = new DefaultEstadoFacade();
                    cidadeFacade = new DefaultCidadeFacade();
                    rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    Cliente clienteUpdate = clientesFacade.buscar(request.getParameter("id"));
                    request.setAttribute("client",clienteUpdate);
                    Cidade cidade = cidadeFacade.buscarCidadePorId(clienteUpdate.getCidadeCliente());
                    request.setAttribute("cidadeCliente", cidade);
                    request.setAttribute("estados",estadoFacade.buscarTodos());
                    request.setAttribute("form","alterar");
                    rd.forward(request, response);
                    break;
                case "remove":
                    clientesFacade.remove(request.getParameter("id"));
                    response.sendRedirect("ClientesServlet");
                    break;
                case "update":
                    try {
                        if(valida.isCPF(request.getParameter("cpfCliente")))
                        {
                        Cliente cliente = new Cliente();
                        cliente.setNomeCliente(request.getParameter("nomeCliente"));
                        cliente.setCpfCliente(request.getParameter("cpfCliente"));
                        cliente.setEmailCliente(request.getParameter("emailCliente"));
                        cliente.setCepCliente(request.getParameter("cepCliente"));
                        cliente.setRuaCliente(request.getParameter("ruaCliente"));
                        cliente.setCidadeCliente(Integer.parseInt(request.getParameter("cidade")));
                        cliente.setNrCliente(Integer.parseInt(request.getParameter("nrCliente")));
                        cliente.setDataCliente(format.parse(request.getParameter("dateCliente")));
                        cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
                        clientesFacade.alterar(cliente);
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response.sendRedirect("ClientesServlet");
                    break;
                case "formNew":
                    estadoFacade = new DefaultEstadoFacade();
                    rd = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    request.setAttribute("estados",estadoFacade.buscarTodos());
                    rd.forward(request, response);
                    break;
                case "new":
                    try {
                        if(valida.isCPF(request.getParameter("cpfCliente")))
                        {
                            Cliente cliente = new Cliente();
                            cliente.setNomeCliente(request.getParameter("nomeCliente"));
                            cliente.setCpfCliente(request.getParameter("cpfCliente"));
                            cliente.setEmailCliente(request.getParameter("emailCliente"));
                            cliente.setCepCliente(request.getParameter("cepCliente"));
                            cliente.setRuaCliente(request.getParameter("ruaCliente"));
                            cliente.setCidadeCliente(Integer.parseInt(request.getParameter("cidade")));
                            cliente.setUfCliente(request.getParameter("ufCliente"));
                            cliente.setNrCliente(Integer.parseInt(request.getParameter("nrCliente")));
                            cliente.setDataCliente(format.parse(request.getParameter("dateCliente")));            
                            clientesFacade.inserir(cliente);
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                    response.sendRedirect("ClientesServlet");
                    break;
                default:
                    rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
                    request.setAttribute("list", clientesFacade.buscarTodos());
                    rd.forward(request, response);
                break;
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
