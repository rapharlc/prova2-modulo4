package com.tech4me.produtoms.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.produtoms.compartilhado.ProdutoDto;
import com.tech4me.produtoms.model.Produto;
import com.tech4me.produtoms.repository.ProdutoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;
    
    @Override
    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        produtoDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = repositorio.save(produto);
        return mapper.map(produto, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repositorio.findAll();
        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);

            if(produto.isPresent()){
                ProdutoDto dto = new ModelMapper().map(produto.get(), ProdutoDto.class);
            
                return Optional.of(dto); 
            }
        return Optional.empty(); 
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produtoDto) {
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = repositorio.save(produto);
        return mapper.map(produto, ProdutoDto.class);
        
    }

    @Override
    public ProdutoDto atualizarEstoque(String id, int quantidadeVendida) {
        Optional<Produto> produto = repositorio.findById(id);
            if(produto.isEmpty()){
                throw new InputMismatchException("Produto com ID" + id + "não encontrado");
            }
            produto.get().setQuantidadeEmEstoque(produto.get().getQuantidadeEmEstoque() - quantidadeVendida);
            repositorio.save(produto.get());
            ProdutoDto produtoDto = new ModelMapper().map(produto.get(), ProdutoDto.class);
            return produtoDto;
    }

    
    }
    

