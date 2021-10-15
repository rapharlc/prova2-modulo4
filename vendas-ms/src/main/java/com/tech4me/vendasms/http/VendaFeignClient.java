package com.tech4me.vendasms.http;






import com.tech4me.vendasms.compartilhado.Produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "produto-ms", fallback = VendaFeignClientFallback.class)
public interface VendaFeignClient {
    
    @GetMapping(path = "/api/produtos/{idProduto}")
    Produto produto(@PathVariable String idProduto);

    //Metodo de cliente http para alterar estoque do produto vendido
    //@PatchMapping(path = "/api/produtos/{id}/{quantidade}")
    //Produto produto(@PathVariable String id, @PathVariable String quantidade);
    
}

@Component
class VendaFeignClientFallback implements VendaFeignClient{

    @Override
    public Produto produto(String idProduto) {
        
        return null;
        
    }

}
