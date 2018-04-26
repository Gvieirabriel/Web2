/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.impl;

import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gqueiroz
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    Connection con = new ConnectionFactory().getConnection();
    //Metodo que recupera da base todas as pessoas e popula uma lista para retornar
    @Override
    public List<Usuario> listPessoa() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT id_pessoa, nm_pessoa, sexo_pessoa FROM tb_pessoa");
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario pessoa = new Usuario();
                pessoa.setIdPessoa(rs.getInt(1));
                list.add(pessoa);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario loginPessoa(String login, String senha) {
       PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT nome_usuario FROM tb_usuario WHERE login_usuario = ? AND senha_usuario = ?");
            ps.setString(1, login);
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            ps.setString(2, Arrays.toString(messageDigest));
            rs = ps.executeQuery();
            Usuario pessoa = new Usuario();
            while (rs.next()) {
                pessoa.setLoginUsuario(login);
                pessoa.setNomeUsuario(rs.getString(1));
            }
            return pessoa;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}