/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade.impl;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.dao.ClienteDAO;
import com.ufpr.tads.web2.dao.impl.ClienteDAOImpl;
import com.ufpr.tads.web2.facade.ClientesFacade;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public class DefaultClientesFacade implements ClientesFacade {
    
    private final ClienteDAO clienteDao;

    public DefaultClientesFacade() {
        this.clienteDao = new ClienteDAOImpl();
    }

    @Override
    public void inserir(Cliente c) {
        clienteDao.insertClient(c);
    }

    @Override
    public void alterar(Cliente c) {
        clienteDao.updateClientById(c);
    }

    @Override
    public Cliente buscar(String id) {
        return clienteDao.getClientById(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteDao.listClients();
    }

    @Override
    public void remove(String id) {
        clienteDao.removeClientById(id);
    }    
}
