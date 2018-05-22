/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.resource;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.LoginFacade;
import com.ufpr.tads.web2.facade.impl.DefaultAtendimentoFacade;
import com.ufpr.tads.web2.facade.impl.DefaultClientesFacade;
import com.ufpr.tads.web2.facade.impl.DefaultLoginFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author gqueiroz
 */
@Path("generic")
public class AtendimentoResource {

      @Context
    private UriInfo context;

    /**
     * Creates a new instance of AtendimentoResource
     */
    private AtendimentoFacade atendimentoFacade;
    private ClientesFacade clientesfacade;
    private LoginFacade loginfacade;
    
    public AtendimentoResource() {
        this.atendimentoFacade = new DefaultAtendimentoFacade();
        this.clientesfacade = new DefaultClientesFacade();
        this.loginfacade = new DefaultLoginFacade();
    }

    /**
     * Retrieves representation of an instance of com.ufpr.tads.web2.ws.AtendimentoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> getAtendimentos() {
        List<Atendimento> atendimentos = atendimentoFacade.buscarTodos();
        return atendimentos;
    }
    
    public Atendimento getAtendimento(int id){
        Atendimento atendimento = new Atendimento();
        atendimento = atendimentoFacade.buscar(id);
        return atendimento;
    }

    /**
     * PUT method for updating or creating an instance of AtendimentoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void setAtendimento(Atendimento atendimento) {
        this.atendimentoFacade.inserir(atendimento);
    }
    
    public void resolveAtendimento(Atendimento atendimento) {
        this.atendimentoFacade.update(atendimento);
    }
}
