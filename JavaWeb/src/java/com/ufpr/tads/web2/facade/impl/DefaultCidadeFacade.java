/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade.impl;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.dao.CidadeDAO;
import com.ufpr.tads.web2.dao.impl.CidadeDAOImpl;
import com.ufpr.tads.web2.facade.CidadeFacade;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public class DefaultCidadeFacade implements CidadeFacade {
    
    private final CidadeDAO cidadeDao;
    
    public DefaultCidadeFacade() {
        this.cidadeDao = new CidadeDAOImpl();
    }
    
    @Override
    public List<Cidade> buscarTodos() {
        return this.cidadeDao.listCidade();
    }

    @Override
    public List<Cidade> buscarTodosPorEstado(String estado) {
        return this.cidadeDao.listCidadePorEstado(estado);
    }

    @Override
    public Cidade buscarCidadePorId(int id) {
        return this.cidadeDao.buscaCidadePorId(id);
    }

}
