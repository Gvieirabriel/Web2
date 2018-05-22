/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade.impl;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.AtendimentoReport;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
import com.ufpr.tads.web2.dao.ProdutoDAO;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;
import com.ufpr.tads.web2.dao.impl.AtendimentoDAOImpl;
import com.ufpr.tads.web2.dao.impl.ProdutoDAOImpl;
import com.ufpr.tads.web2.dao.impl.TipoAtendimentoDAOImpl;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public class DefaultAtendimentoFacade implements AtendimentoFacade {

    public ProdutoDAO produtoDao;
    public TipoAtendimentoDAO tipoAtendimentoDao;
    public AtendimentoDAO atendimentoDAO;


    public DefaultAtendimentoFacade() {
        produtoDao = new ProdutoDAOImpl();
        tipoAtendimentoDao = new TipoAtendimentoDAOImpl();
        atendimentoDAO = new AtendimentoDAOImpl();
    }
    
    @Override
    public void inserir(Atendimento c) {
        this.atendimentoDAO.insertAtendimentos(c);
    }

    @Override
    public Atendimento buscar(int id) {
        return this.atendimentoDAO.getAtendimentosById(id);
    }

    @Override
    public List<Atendimento> buscarTodos(String loginUsuario) {
        return this.atendimentoDAO.listAtendimentos(loginUsuario);
    }

    @Override
    public List<Produto> buscarTodosProdutos() {
        return produtoDao.listProduto();
    }

    @Override
    public List<TipoAtendimento> buscarTodosTipoAtendimento() {
        return tipoAtendimentoDao.listTipos();
    }

    @Override
    public Produto buscarProduto(int idProduto) {
        return this.produtoDao.buscaProdutoPorId(idProduto);
    }

    @Override
    public TipoAtendimento buscarTipoAtendimento(int idTipoAtendimento) {
        return this.tipoAtendimentoDao.buscaTipoPorId(idTipoAtendimento);
    }

    @Override
    public void inserirProduto(Produto p) {
       this.produtoDao.insertProduto(p);
    }

    @Override
    public void removerProduto(int idProduto) {
        this.produtoDao.removeProduto(idProduto);
    }

    @Override
    public List<Atendimento> buscarTodos() {
        return this.atendimentoDAO.listAtendimentos();
    }

    @Override
    public void update(Atendimento atendimento) {
        this.atendimentoDAO.updateAtendimento(atendimento);
    }

    @Override
    public List<AtendimentoReport> listAtendimentosBetweenDates(Date di, Date df) {
        return this.atendimentoDAO.listAtendimentosBetweenDates(di, df);
    }

    @Override
    public List<AtendimentoReport> listAtendimentosByType(String tipo) {
        return this.atendimentoDAO.listAtendimentosByType(tipo);
    }

    @Override
    public List<AtendimentoReport> listAtendimentosResolvidos() {
        return this.atendimentoDAO.listAtendimentosResolvidos();
    }
}
