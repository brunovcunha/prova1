package com.iftm.bruno.prova1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.bruno.prova1.model.Endereco;
import com.iftm.bruno.prova1.service.EnderecoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * EnderecoController
 */

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Endereco> enderecos(@RequestBody Endereco endereco) {
        service.addEndereco(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco() {

        List<Endereco> enderecos = service.getEnderecos();

        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

}