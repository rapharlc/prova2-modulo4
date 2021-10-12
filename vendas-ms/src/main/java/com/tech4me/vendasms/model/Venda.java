package com.tech4me.vendasms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Venda {
    @Id
    private String id;
    private String dataDaVenda;
    private String idProdutoVendido;
    private int quantidadeVendida;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDataDaVenda() {
        return dataDaVenda;
    }
    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
    public String getIdProdutoVendido() {
        return idProdutoVendido;
    }
    public void setIdProdutoVendido(String idProdutoVendido) {
        this.idProdutoVendido = idProdutoVendido;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }


    
    
}
