/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.util.Date;

/**
 *
 * @author gqueiroz
 */
public class Atendimento {
        
    private int idAtendimento;
    
    private int idProduto;
    
    private int idTipoAtendimento;
    
    private int idUsuario;
    
    private int idCliente;
    
    private char resAtendimento;
    
    private String dscAtendimento;
    
    private Date dtHrAtendimento;

    /**
     * @return the idAtendimento
     */
    public int getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * @param idAtendimento the idAtendimento to set
     */
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idTipoAtendimento
     */
    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    /**
     * @param idTipoAtendimento the idTipoAtendimento to set
     */
    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the resAtendimento
     */
    public char getResAtendimento() {
        return resAtendimento;
    }

    /**
     * @param resAtendimento the resAtendimento to set
     */
    public void setResAtendimento(char resAtendimento) {
        this.resAtendimento = resAtendimento;
    }

    /**
     * @return the dscAtendimento
     */
    public String getDscAtendimento() {
        return dscAtendimento;
    }

    /**
     * @param dscAtendimento the dscAtendimento to set
     */
    public void setDscAtendimento(String dscAtendimento) {
        this.dscAtendimento = dscAtendimento;
    }

    /**
     * @return the dtHrAtendimento
     */
    public Date getDtHrAtendimento() {
        return dtHrAtendimento;
    }

    /**
     * @param dtHrAtendimento the dtHrAtendimento to set
     */
    public void setDtHrAtendimento(Date dtHrAtendimento) {
        this.dtHrAtendimento = dtHrAtendimento;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
