package com.tech4me.vendasms.compartilhado;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class VendaDto {
    

    private String id;
    private String dataDaVenda;
    @NotBlank(message = "A Id do produto vendido deve ser preenchida")
    @NotEmpty(message = "A Id do produto vendido dever diferente de vazio")
    private String idProdutoVendido;
    @Positive(message = "A quantidade vendida deve ser maior que zero")
    private String quantidadeVendida;
    private Produto produto;
    
    public String getId() {
        return id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
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
    public String getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(String quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }


    
    
}

