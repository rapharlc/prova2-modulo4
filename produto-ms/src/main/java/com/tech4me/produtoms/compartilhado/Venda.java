package com.tech4me.produtoms.compartilhado;

public class Venda {
    
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
