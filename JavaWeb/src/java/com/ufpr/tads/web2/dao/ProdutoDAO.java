/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Produto;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public interface ProdutoDAO {
        
    List<Produto> listProduto();  
    
    Produto buscaProdutoPorId(int id);
    
    void insertProduto(Produto produto);
   
    public void removeProduto(int idProduto);
}
