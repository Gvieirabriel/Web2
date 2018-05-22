/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.impl;

import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;
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
public class TipoAtendimentoDAOImpl implements TipoAtendimentoDAO {

    Connection con = new ConnectionFactory().getConnection();

    @Override
    public List<TipoAtendimento> listTipos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_tipo_atendimento");
            rs = ps.executeQuery();
            List<TipoAtendimento> list = new ArrayList<TipoAtendimento>();
            while (rs.next()) {
                TipoAtendimento p = new TipoAtendimento();
                p.setIdTipoAtendimento(rs.getInt(1));
                p.setNomeTipoAtendimento(rs.getString(2));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public TipoAtendimento buscaTipoPorId(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_tipo_atendimento where id_tipo_atendimento = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<TipoAtendimento> list = new ArrayList<TipoAtendimento>();
            while (rs.next()) {
                TipoAtendimento p = new TipoAtendimento();
                p.setIdTipoAtendimento(rs.getInt(1));
                p.setNomeTipoAtendimento(rs.getString(2));
                list.add(p);
            }
            return list.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
