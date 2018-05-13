/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author gqueiroz
 */
public class TipoAtendimento {
        
    private int idTipoAtendimento;
    
    private String nomeTipoAtendimento;

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
     * @return the nomeTipoAtendimento
     */
    public String getNomeTipoAtendimento() {
        return nomeTipoAtendimento;
    }

    /**
     * @param nomeTipoAtendimento the nomeTipoAtendimento to set
     */
    public void setNomeTipoAtendimento(String nomeTipoAtendimento) {
        this.nomeTipoAtendimento = nomeTipoAtendimento;
    }
}
