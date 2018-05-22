/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.AtendimentoReport;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.impl.DefaultAtendimentoFacade;
import com.ufpr.tads.web2.facade.impl.DefaultClientesFacade;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author gqueiroz
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/ReportServlet"})
public class ReportServlet extends HttpServlet {
    private ClientesFacade clienntesFacade;
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
       clienntesFacade = new DefaultClientesFacade();
       atendimentoFacade = new DefaultAtendimentoFacade();

        String action = request.getParameter("action");
        String host = "http://" + request.getServerName() + ":" + request.getServerPort();
        byte[] bytes = null;
        HashMap params = null;
        String jasper = null;
        URL jasperURL = null;
        try {
            if(action.equals("cliente"))
            {
                jasper = request.getContextPath() + "/clientReport.jasper";

                jasperURL = new URL(host + jasper);

                params = new HashMap();

                List<Cliente> lista = clienntesFacade.buscarTodos();
                
                if(lista!=null)
                bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params,new JRBeanCollectionDataSource(lista));
            } else if(action.equals("atendimentoIntervalo")) {
                        
            } else if(action.equals("atendimentoTipo")) {
                jasper = request.getContextPath() + "/atendimentoTipoReport.jasper";

                jasperURL = new URL(host + jasper);

                params = new HashMap();
                params.put("tipoAtendimentos",atendimentoFacade.buscarTipoAtendimento(Integer.parseInt(request.getParameter("tipo"))).getNomeTipoAtendimento());
                
                List<AtendimentoReport> lista = atendimentoFacade.listAtendimentosByType(request.getParameter("tipo"));
                
                if(lista!=null)
                bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params,new JRBeanCollectionDataSource(lista));
  
            } else if(action.equals("atendimentoResolvido")) {
                jasper = request.getContextPath() + "/atendimentoResolvidoReport.jasper";

                jasperURL = new URL(host + jasper);

                params = new HashMap();

                List<AtendimentoReport> lista = atendimentoFacade.listAtendimentosResolvidos();
                
                if(lista!=null)
                bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params,new JRBeanCollectionDataSource(lista));
            } else {
                request.setAttribute("mensagem", "Erro ao tentar requisitar relatorio");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

            if (bytes != null) {
                response.setContentType("application/pdf");

                OutputStream ops = response.getOutputStream();
                ops.write(bytes);
            }
        }
        catch (JRException e) {
            request.setAttribute("mensagem", "Erro no Jasper : "
                    + e.getMessage());
            request.setAttribute("page", "portal.jsp");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
        catch (NullPointerException e)
        {
            request.setAttribute("mensagem", "Erro ao gerar relatorio : "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
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
