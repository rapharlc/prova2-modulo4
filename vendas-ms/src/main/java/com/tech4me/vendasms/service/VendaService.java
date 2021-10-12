package com.tech4me.vendasms.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.vendasms.compartilhado.VendaDto;

public interface VendaService {
    
    VendaDto criarVenda(VendaDto vendaDto);
    List<VendaDto> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    //List<VendaDto> obterPorIdDoProduto(String idDoProduto);
    void removerVenda(String id);
}
