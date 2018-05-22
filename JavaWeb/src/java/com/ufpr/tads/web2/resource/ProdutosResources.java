/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.resource;

import com.ufpr.tads.web2.beans.Produto;
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
@Path("produtosresources")
public class ProdutosResources {

    @Context
    private UriInfo context;
    private AtendimentoFacade atendimentoFacade;
    private ClientesFacade clientesfacade;
    private LoginFacade loginfacade;
    /**
     * Creates a new instance of ProdutosResources
     */
    public ProdutosResources() {
        this.atendimentoFacade = new DefaultAtendimentoFacade();
        this.clientesfacade = new DefaultClientesFacade();
        this.loginfacade = new DefaultLoginFacade();
    }

    /**
     * Retrieves representation of an instance of com.ufpr.tads.web2.resource.ProdutosResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos() {
        List<Produto> produtos = atendimentoFacade.buscarTodosProdutos();
        return produtos;
    }
    public Produto getProduto(int id){
        Produto produto = new Produto();
        produto = atendimentoFacade.buscarProduto(id);
        return produto;
    }

    /**
     * PUT method for updating or creating an instance of ProdutosResources
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void setProduto(Produto produto) {
        this.atendimentoFacade.inserirProduto(produto);
    }
    
    public void removeProduto(int id){
        this.atendimentoFacade.removerProduto(id);
    }
}
