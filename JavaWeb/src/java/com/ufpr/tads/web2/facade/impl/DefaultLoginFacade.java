/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade.impl;

import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import com.ufpr.tads.web2.dao.impl.UsuarioDAOImpl;
import com.ufpr.tads.web2.facade.LoginFacade;

/**
 *
 * @author gqueiroz
 */
public class DefaultLoginFacade implements LoginFacade {

    @Override
    public Usuario buscarUsuario(String id, String senha) {
        UsuarioDAO dao = new UsuarioDAOImpl();
        Usuario pessoa = dao.loginPessoa(id, senha);
        return pessoa;
    }

    @Override
    public Usuario buscarUsuario(String login) {
        UsuarioDAO dao = new UsuarioDAOImpl();
        Usuario pessoa = dao.loginPessoa(login);
        return pessoa;
    }
    
}
