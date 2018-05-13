/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.TipoAtendimento;
import java.util.List;

/**
 *
 * @author gqueiroz
 */
public interface TipoAtendimentoDAO {
            
    List<TipoAtendimento> listProduto();  
    
    TipoAtendimento buscaProdutoPorId(int id);
}
