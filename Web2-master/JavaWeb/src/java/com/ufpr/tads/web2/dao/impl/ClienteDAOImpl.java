/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao.impl;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.dao.ClienteDAO;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class ClienteDAOImpl implements ClienteDAO{

    Connection con = new ConnectionFactory().getConnection();

    @Override
    public List<Cliente> listClients() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_cliente");
            rs = ps.executeQuery();
            List<Cliente> list = new ArrayList<Cliente>();
            Calendar cal = Calendar.getInstance();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCpfCliente(rs.getString(2));
                cliente.setNomeCliente(rs.getString(3));
                cliente.setEmailCliente(rs.getString(4));
                cliente.setCepCliente(rs.getString(5));
                cliente.setRuaCliente(rs.getString(6));
                cliente.setNrCliente(rs.getInt(7));
                cliente.setCidadeCliente(rs.getString(8));
                cal.setTime(rs.getDate(9));
                cliente.setDataCliente(cal.getTime());
                cliente.setUfCliente(rs.getString(10));
                list.add(cliente);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente getClientById(String idCliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tb_cliente WHERE id_cliente = ?");
            ps.setString(1, idCliente);
            rs = ps.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCpfCliente(rs.getString(2));
                cliente.setNomeCliente(rs.getString(3));
                cliente.setEmailCliente(rs.getString(4));
                cliente.setCepCliente(rs.getString(5));
                cliente.setRuaCliente(rs.getString(6));
                cliente.setNrCliente(rs.getInt(7));
                cliente.setCidadeCliente(rs.getString(8));
                cliente.setDataCliente(rs.getTimestamp(9));
                cliente.setUfCliente(rs.getString(10));
            }
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeClientById(String id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("DELETE FROM tb_cliente WHERE id_cliente = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateClientById(Cliente cliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("UPDATE tb_cliente SET cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, cep_cliente = ?, rua_cliente = ?, nr_cliente = ?, cidade_cliente = ?, data_cliente = ?, uf_cliente = ? WHERE id_cliente = ?");
            ps.setString(1, cliente.getCpfCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getEmailCliente());
            ps.setString(4, cliente.getCepCliente());
            ps.setString(5, cliente.getRuaCliente());
            ps.setInt(6, cliente.getNrCliente());
            ps.setString(7, cliente.getCidadeCliente());
            ps.setDate(8, new java.sql.Date(cliente.getDataCliente().getTime()));
            ps.setString(9, cliente.getUfCliente());
            ps.setInt(10, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertClient(Cliente cliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("INSERT INTO tb_cliente (cpf_cliente, nome_cliente, email_cliente, cep_cliente, rua_cliente, nr_cliente, cidade_cliente, data_cliente, uf_cliente) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpfCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getEmailCliente());
            ps.setString(4, cliente.getCepCliente());
            ps.setString(5, cliente.getRuaCliente());
            ps.setInt(6, cliente.getNrCliente());
            ps.setString(7, cliente.getCidadeCliente());
            ps.setDate(8, new java.sql.Date(cliente.getDataCliente().getTime()));
            ps.setString(9, cliente.getUfCliente());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
