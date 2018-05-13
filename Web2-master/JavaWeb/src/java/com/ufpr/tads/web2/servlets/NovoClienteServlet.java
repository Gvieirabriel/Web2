/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.ClienteDAO;
import com.ufpr.tads.web2.dao.impl.ClienteDAOImpl;
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
 * @author Pichau
 */
@WebServlet(name = "NovoClienteServlet", urlPatterns = {"/NovoClienteServlet"})
public class NovoClienteServlet extends HttpServlet {
    private HttpSession session;
    private RequestDispatcher rd;
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
        LoginBean login = (LoginBean) session.getAttribute("loginBean");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Cliente cliente = new Cliente();
            cliente.setNomeCliente(request.getParameter("nomeCliente"));
            cliente.setCpfCliente(request.getParameter("cpfCliente"));
            cliente.setEmailCliente(request.getParameter("emailCliente"));
            cliente.setCepCliente(request.getParameter("cepCliente"));
            cliente.setRuaCliente(request.getParameter("ruaCliente"));
            cliente.setCidadeCliente(request.getParameter("cidadeCliente"));
            cliente.setUfCliente(request.getParameter("ufCliente"));
            cliente.setNrCliente(Integer.parseInt(request.getParameter("nrCliente")));
            cliente.setDataCliente(format.parse(request.getParameter("dateCliente")));            
            ClienteDAO dao = new ClienteDAOImpl();
            dao.insertClient(cliente);
        } catch (ParseException ex) {
            Logger.getLogger(AlterarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (login == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            rd = getServletContext().getRequestDispatcher("/ClientesServlet");
            rd.forward(request, response);
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
