package com.tech4me.vendasms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.vendasms.VendasMsApplication;
import com.tech4me.vendasms.compartilhado.VendaDto;
import com.tech4me.vendasms.http.VendaFeignClient;
import com.tech4me.vendasms.model.Venda;
import com.tech4me.vendasms.repository.VendaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repositorioVenda;
    @Autowired
    private VendaFeignClient produtoMsClient;
    @Override
    public VendaDto criarVenda(VendaDto vendaDto) {
        ModelMapper mapper = new ModelMapper();
        Venda vendaEntidade = mapper.map(vendaDto, Venda.class);
        vendaEntidade = repositorioVenda.save(vendaEntidade);
        VendaDto dto = mapper.map(vendaEntidade, VendaDto.class);
        return dto; 
    }

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repositorioVenda.findAll();
        return vendas.stream().map(venda -> new ModelMapper().map(venda, VendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> venda = repositorioVenda.findById(id);
        if(venda.isPresent()){
            String idProduto = venda.get().getIdProdutoVendido();
            VendaDto dto = new ModelMapper().map(venda.get(), VendaDto.class);
            dto.setProduto(produtoMsClient.produto(idProduto));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public void removerVenda(String id) {
        repositorioVenda.deleteById(id);
        
    }

    
    
} 
