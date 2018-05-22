/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.AtendimentoReport;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public interface AtendimentoFacade {
    public void inserir(Atendimento c);
        
    public Atendimento buscar(int id);
    
    public List<Atendimento> buscarTodos(String loginUsuario);
    
    public List<Produto> buscarTodosProdutos();
    
    public List<TipoAtendimento> buscarTodosTipoAtendimento();

    public Produto buscarProduto(int idProduto);

    public TipoAtendimento buscarTipoAtendimento(int idTipoAtendimento);
    
    public void inserirProduto(Produto p);
    
    public void removerProduto(int idProduto);

    public List<Atendimento> buscarTodos();

    public void update(Atendimento atendimento);
    
    public List<AtendimentoReport> listAtendimentosBetweenDates(Date di, Date df);
    
    public List<AtendimentoReport> listAtendimentosByType(String tipo);
    
    public List<AtendimentoReport> listAtendimentosResolvidos();
}
    