package com.tech4me.produtoms.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.produtoms.compartilhado.ProdutoDto;
import com.tech4me.produtoms.service.ProdutoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl servicoProduto;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> obterTodos(){
        return new ResponseEntity<>(servicoProduto.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Optional<ProdutoDto>> obterPorId(@PathVariable String idProduto){
        Optional<ProdutoDto> produtoEncontrado = servicoProduto.obterPorId(idProduto);
        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody @Valid ProdutoDto produtoDto){
        ProdutoDto produtoAdicionado = servicoProduto.criarProduto(produtoDto);
        return new ResponseEntity<>(produtoAdicionado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoProduto.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable String id, @RequestBody @Valid ProdutoDto produtoDto){
        ProdutoDto produtoAtualizado = servicoProduto.atualizarProduto(id, produtoDto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    
   @PatchMapping("/{id}/{quantidade}")
   public ResponseEntity<ProdutoDto> atualizarEstoque(@PathVariable String id, @Valid @PathVariable String quantidade){
       int quantidadeEstoque = Integer.parseInt(quantidade);
       ProdutoDto produtoVendido = servicoProduto.atualizarEstoque(id,  quantidadeEstoque);
       return new ResponseEntity<>(produtoVendido, HttpStatus.OK);
   } 
}
