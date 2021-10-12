package com.tech4me.produtoms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produto {

    @Id
    private String id;
    private String codigoDoProduto;
    private String nomeDoProduto;
    private double valorDoProduto;
    private int quantidadeEmEstoque;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }
    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }
    public double getValorDoProduto() {
        return valorDoProduto;
    }
    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    

    
}
