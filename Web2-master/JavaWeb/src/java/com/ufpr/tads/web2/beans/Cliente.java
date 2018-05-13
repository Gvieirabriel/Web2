/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pichau
 */
public class Cliente implements Serializable {
    
    private int idCliente;

    private String cpfCliente;

    private String nomeCliente;
    
    private String emailCliente;
    
    private String cepCliente;
     
    private String ruaCliente;
    
    private String cidadeCliente;
    
    private String ufCliente;
    
    private int nrCliente;
    
    private Date dataCliente;

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

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the emailCliente
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * @param emailCliente the emailCliente to set
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     * @return the cepCliente
     */
    public String getCepCliente() {
        return cepCliente;
    }

    /**
     * @param cepCliente the cepCliente to set
     */
    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    /**
     * @return the ruaCliente
     */
    public String getRuaCliente() {
        return ruaCliente;
    }

    /**
     * @param ruaCliente the ruaCliente to set
     */
    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    /**
     * @return the cidadeCliente
     */
    public String getCidadeCliente() {
        return cidadeCliente;
    }

    /**
     * @param cidadeCliente the cidadeCliente to set
     */
    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    /**
     * @return the ufCliente
     */
    public String getUfCliente() {
        return ufCliente;
    }

    /**
     * @param ufCliente the ufCliente to set
     */
    public void setUfCliente(String ufCliente) {
        this.ufCliente = ufCliente;
    }

    /**
     * @return the nrCliente
     */
    public int getNrCliente() {
        return nrCliente;
    }

    /**
     * @param nrCliente the nrCliente to set
     */
    public void setNrCliente(int nrCliente) {
        this.nrCliente = nrCliente;
    }

    /**
     * @return the dataCliente
     */
    public Date getDataCliente() {
        return dataCliente;
    }

    /**
     * @param dataCliente the dataCliente to set
     */
    public void setDataCliente(Date dataCliente) {
        this.dataCliente = dataCliente;
    }
}
