package com.tech4me.vendasms.view.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.vendasms.compartilhado.VendaDto;
import com.tech4me.vendasms.service.VendaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaServiceImpl servicoVenda;

    @GetMapping
    public ResponseEntity<List<VendaDto>> obterTodos(){
        return new ResponseEntity<>(servicoVenda.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VendaDto>> obterPorId(@PathVariable String id){
        Optional<VendaDto> vendaEncontrada = servicoVenda.obterPorId(id);
        return new ResponseEntity<>(vendaEncontrada, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<VendaDto> criarVenda(@RequestBody @Valid VendaDto vendaDto){
        VendaDto vendaAdicionada = servicoVenda.criarVenda(vendaDto);
        return new ResponseEntity<>(vendaAdicionada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerVenda(@PathVariable String id){
        servicoVenda.removerVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    
    
}
