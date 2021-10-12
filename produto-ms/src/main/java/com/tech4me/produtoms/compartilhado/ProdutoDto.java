package com.tech4me.produtoms.compartilhado;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class ProdutoDto {
    
    private String id;
    private String codigoDoProduto;
    @NotBlank(message = "O nome do produto deve conter caracteres não brancos")
    @NotEmpty(message = "O nome do produto não pode ser nulo")
    private String nomeDoProduto;
    private double valorDoProduto;
    @Positive(message = "O número em estoque deve ser maior que zero")
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
