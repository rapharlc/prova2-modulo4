package com.tech4me.vendasms.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.vendasms.compartilhado.VendaDto;
import com.tech4me.vendasms.view.model.VendaResponse;

public interface VendaService {
    
    VendaDto criarVenda(VendaDto vendaDto);
    List<VendaResponse> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    void removerVenda(String id);
    
}
