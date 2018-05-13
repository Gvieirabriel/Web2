/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade.impl;

import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.dao.EstadoDAO;
import com.ufpr.tads.web2.dao.impl.EstadoDAOImpl;
import com.ufpr.tads.web2.facade.EstadoFacade;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public class DefaultEstadoFacade implements EstadoFacade {

    private final EstadoDAO estadoDao;
    
    public DefaultEstadoFacade() {
        this.estadoDao = new EstadoDAOImpl();
    }
    
    @Override
    public List<Estado> buscarTodos() {
        return estadoDao.listEstado();
    }
    
}
