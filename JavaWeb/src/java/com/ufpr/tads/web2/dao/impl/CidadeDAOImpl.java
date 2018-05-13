/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.impl;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.dao.CidadeDAO;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public class CidadeDAOImpl implements CidadeDAO {

    Connection con = new ConnectionFactory().getConnection();
    
    @Override
    public List<Cidade> listCidade() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_cidade");
            rs = ps.executeQuery();
            List<Cidade> list = new ArrayList<Cidade>();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt(1));
                cidade.setIdEstado(rs.getInt(2));
                cidade.setNomeCidade(rs.getString(3));
                list.add(cidade);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cidade buscaCidadePorId(int id) {
PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_cidade WHERE id_cidade = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Cidade cidade = new Cidade();
            while (rs.next()) {
                cidade.setIdCidade(rs.getInt(1));
                cidade.setIdEstado(rs.getInt(2));
                cidade.setNomeCidade(rs.getString(3));
            }
            return cidade;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cidade> listCidadePorEstado(String estado) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_cidade WHERE id_estado=?");
            ps.setString(1, estado);
            rs = ps.executeQuery();
            List<Cidade> list = new ArrayList<Cidade>();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt(1));
                cidade.setIdEstado(rs.getInt(2));
                cidade.setNomeCidade(rs.getString(3));
                list.add(cidade);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
