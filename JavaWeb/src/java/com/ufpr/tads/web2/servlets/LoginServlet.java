/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import com.ufpr.tads.web2.dao.impl.UsuarioDAOImpl;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import com.ufpr.tads.web2.facade.LoginFacade;
import com.ufpr.tads.web2.facade.impl.DefaultAtendimentoFacade;
import com.ufpr.tads.web2.facade.impl.DefaultLoginFacade;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private HttpSession session;
    private RequestDispatcher rd;
    private LoginFacade loginFacade;
    private AtendimentoFacade atendimentoFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        //Inicio do printwriter do servlet
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
        atendimentoFacade = new DefaultAtendimentoFacade();
        session = request.getSession();
        loginFacade = new DefaultLoginFacade();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Usuario buscarUsuario = loginFacade.buscarUsuario(login, senha);
        
        if (buscarUsuario.getNomeUsuario() == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário/Senha inválidos!");
            rd.forward(request, response);
        } else {
            LoginBean loginBean = new LoginBean();
            List<TipoAtendimento> tipos = atendimentoFacade.buscarTodosTipoAtendimento();
            request.setAttribute("tipos", tipos);
            loginBean.setLoginUsuario(buscarUsuario.getLoginUsuario());
            loginBean.setNomeUsuario(buscarUsuario.getNomeUsuario());
            RequestDispatcher rd = request.getRequestDispatcher("portal.jsp");
            session.setAttribute("loginBean", loginBean);
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
