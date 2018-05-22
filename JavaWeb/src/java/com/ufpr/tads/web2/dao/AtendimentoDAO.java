/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.AtendimentoReport;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public interface AtendimentoDAO {
    public List<Atendimento> listAtendimentos(String loginUsuario);
    
    public void insertAtendimentos(Atendimento cliente);

    public List<Atendimento> listAtendimentos();
   
    public List<AtendimentoReport> listAtendimentosBetweenDates(Date di, Date df);
    
    public List<AtendimentoReport> listAtendimentosByType(String tipo);
    
    public List<AtendimentoReport> listAtendimentosResolvidos();

    public Atendimento getAtendimentosById(int id);

    public void updateAtendimento(Atendimento atendimento);
}
