/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.impl;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.AtendimentoReport;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gqueiroz
 */
public class AtendimentoDAOImpl implements AtendimentoDAO {

    Connection con = new ConnectionFactory().getConnection();
    
    @Override
    public List<Atendimento> listAtendimentos(String loginUsuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_atendimento as a, tb_usuario as t where a.id_usuario = t.id and t.login_usuario = ?");
            ps.setString(1, loginUsuario);
            rs = ps.executeQuery();
            List<Atendimento> list = new ArrayList<Atendimento>();
            Calendar cal = Calendar.getInstance();

            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt(1));
                cal.setTime(rs.getDate(2));
                atendimento.setDtHrAtendimento(cal.getTime());
                atendimento.setDscAtendimento(rs.getString(3));
                atendimento.setResAtendimento(rs.getString(4).charAt(0));
                atendimento.setIdProduto(rs.getInt(5));
                atendimento.setIdTipoAtendimento(rs.getInt(6));
                atendimento.setIdUsuario(rs.getInt(7));
                atendimento.setIdCliente(rs.getInt(8));
                list.add(atendimento);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Atendimento getAtendimentosById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("select id_atendimento, dt_hr_atendimento, "
                    + "dsc_atendimento, id_usuario, id_produto, id_tipo_atendimento, "
                    + "id_cliente, res_atendimento from tb_atendimento "
                    + "WHERE id_atendimento = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            Atendimento atendimento = new Atendimento();
            while (rs.next()) { 
                atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
                atendimento.setDtHrAtendimento(new java.util.Date(rs.getTimestamp("dt_hr_atendimento").getTime()));
                atendimento.setDscAtendimento(rs.getString("dsc_atendimento"));
                atendimento.setIdProduto(rs.getInt("id_produto"));
                atendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
                atendimento.setIdUsuario(rs.getInt("id_usuario"));
                atendimento.setIdCliente(rs.getInt("id_cliente"));
                atendimento.setResAtendimento(rs.getString("res_atendimento").charAt(0));
                return atendimento;
            }
            return atendimento;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertAtendimentos(Atendimento cliente) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("INSERT INTO tb_atendimento ("
                    + "dt_hr_atendimento, dsc_atendimento, id_cliente, id_produto, id_tipo_atendimento, id_usuario, res_atendimento)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setDate(1, new java.sql.Date(cliente.getDtHrAtendimento().getTime()));
            st.setString(2, cliente.getDscAtendimento());
            st.setInt(3, cliente.getIdCliente());
            st.setInt(4,cliente.getIdProduto());
            st.setInt(5, cliente.getIdTipoAtendimento());
            st.setInt(6, cliente.getIdUsuario());
            st.setString(7,String.valueOf(cliente.getResAtendimento()));  
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Atendimento> listAtendimentos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_atendimento as a, tb_usuario as t");
            rs = ps.executeQuery();
            List<Atendimento> list = new ArrayList<Atendimento>();
            Calendar cal = Calendar.getInstance();

            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt(1));
                cal.setTime(rs.getDate(2));
                atendimento.setDtHrAtendimento(cal.getTime());
                atendimento.setDscAtendimento(rs.getString(3));
                atendimento.setResAtendimento(rs.getString(4).charAt(0));
                atendimento.setIdProduto(rs.getInt(5));
                atendimento.setIdTipoAtendimento(rs.getInt(6));
                atendimento.setIdUsuario(rs.getInt(7));
                atendimento.setIdCliente(rs.getInt(8));
                list.add(atendimento);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAtendimento(Atendimento atendimento) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("UPDATE tb_atendimento SET res_atendimento = ? WHERE id_atendimento = ?");
            ps.setString(1, String.valueOf(atendimento.getResAtendimento()));
            ps.setInt(2, atendimento.getIdAtendimento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AtendimentoReport> listAtendimentosBetweenDates(Date di, Date df) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT a.res_atendimento, a.dt_hr_atendimento,t.nome_cliente, tipo.nome_tipo_atendimento "
                    + "FROM tb_atendimento as a, tb_cliente as t, tb_tipo_atendimento as tipo "
                    + "WHERE a.id_cliente = t.id_cliente AND a.id_tipo_atendimento = tipo.id_tipo_atendimento AND a.dt_hr_atendimento >= ? AND a.dt_hr_atendimento <= ? ORDER BY a.dt_hr_atendimento ASC");
            ps.setDate(1, new java.sql.Date(di.getTime()));
            ps.setDate(2, new java.sql.Date(df.getTime()));
            rs = ps.executeQuery();
            List<AtendimentoReport> list = new ArrayList<AtendimentoReport>();
            Calendar cal = Calendar.getInstance();
                System.out.println("Temo?"+ps);

            while (rs.next()) {
                AtendimentoReport atendimento = new AtendimentoReport();
                cal.setTime(rs.getDate("a.dt_hr_atendimento"));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:MM");
                atendimento.setDataAtendimento(format.format(cal.getTime()));
                atendimento.setNomeCliente(rs.getString("t.nome_cliente"));
                atendimento.setTipo(rs.getString("tipo.nome_tipo_atendimento"));
                if(rs.getString("a.res_atendimento").equals("S"))
                    atendimento.setEstado("Resolvido");
                else
                    atendimento.setEstado("Não Resolvido");
                list.add(atendimento);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AtendimentoReport> listAtendimentosByType(String tipo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT a.res_atendimento, a.dt_hr_atendimento,t.nome_cliente, tipo.nome_tipo_atendimento "
                    + "FROM tb_atendimento as a, tb_cliente as t, tb_tipo_atendimento as tipo "
                    + "WHERE a.id_cliente = t.id_cliente AND a.id_tipo_atendimento = tipo.id_tipo_atendimento AND tipo.id_tipo_atendimento = ? ORDER BY a.dt_hr_atendimento ASC");
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            List<AtendimentoReport> list = new ArrayList<AtendimentoReport>();
            Calendar cal = Calendar.getInstance();

            while (rs.next()) {
                AtendimentoReport atendimento = new AtendimentoReport();
                cal.setTime(rs.getDate("a.dt_hr_atendimento"));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:MM");
                atendimento.setDataAtendimento(format.format(cal.getTime()));
                atendimento.setNomeCliente(rs.getString("t.nome_cliente"));
                atendimento.setTipo(rs.getString("tipo.nome_tipo_atendimento"));
                if(rs.getString("a.res_atendimento").equals("S"))
                    atendimento.setEstado("Resolvido");
                else
                    atendimento.setEstado("Não Resolvido");
                list.add(atendimento);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AtendimentoReport> listAtendimentosResolvidos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT a.dt_hr_atendimento,t.nome_cliente, tipo.nome_tipo_atendimento "
                    + "FROM tb_atendimento as a, tb_cliente as t, tb_tipo_atendimento as tipo "
                    + "WHERE a.id_cliente = t.id_cliente AND a.id_tipo_atendimento = tipo.id_tipo_atendimento AND res_atendimento = 'S' ORDER BY a.dt_hr_atendimento DESC");
            rs = ps.executeQuery();
            List<AtendimentoReport> list = new ArrayList<AtendimentoReport>();
            Calendar cal = Calendar.getInstance();

            while (rs.next()) {
                AtendimentoReport atendimento = new AtendimentoReport();
                cal.setTime(rs.getDate("a.dt_hr_atendimento"));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:MM");
                atendimento.setDataAtendimento(format.format(cal.getTime()));
                atendimento.setNomeCliente(rs.getString("t.nome_cliente"));
                atendimento.setTipo(rs.getString("tipo.nome_tipo_atendimento"));
                list.add(atendimento);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
