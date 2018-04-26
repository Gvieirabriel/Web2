/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Cliente;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public interface ClientesFacade {
    
    public void inserir(Cliente c);
    
    public void alterar(Cliente c);
    
    public Cliente buscar(String id);
    
    public List<Cliente> buscarTodos();
    
    public void remove(String id);
}
