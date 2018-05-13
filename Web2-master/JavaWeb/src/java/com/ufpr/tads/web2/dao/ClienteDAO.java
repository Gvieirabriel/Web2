/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cliente;
import java.util.List;

/**
 *
 * @author Pichau
 */
public interface ClienteDAO {
    public List<Cliente> listClients();
    
    public Cliente getClientById(String idCliente);
    
    public void removeClientById(String id);
    
    public void updateClientById(Cliente cliente);
    
    public void insertClient(Cliente cliente);
}
