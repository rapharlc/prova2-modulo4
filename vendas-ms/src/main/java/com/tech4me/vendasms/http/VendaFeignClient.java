package com.tech4me.vendasms.http;

import java.util.List;
import java.util.Optional;

import com.tech4me.vendasms.compartilhado.Produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "produto-ms")
public interface VendaFeignClient {
    //@PatchMapping(path = "/api/produtos/{id}/{quantidade}")
   // List<Produto> atualizarEstoque(@PathVariable String id, @PathVariable int quantidade);
    @GetMapping(path = "/api/produtos/{idProduto}")
    Produto produto(@PathVariable String idProduto);
    
}
