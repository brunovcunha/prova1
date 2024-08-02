package com.iftm.bruno.prova1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.bruno.prova1.model.Rastreamento;
import com.iftm.bruno.prova1.service.RastreamentoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("rastreamentos")
public class RastreamentoController {
    
    @Autowired
    private RastreamentoService service;

    @GetMapping
    public ResponseEntity<List<Rastreamento>> getMethodName(@RequestParam String param) {
        
        List<Rastreamento> rastreamentos = service.getRastreamentos();
        
        return new ResponseEntity<>(rastreamentos, HttpStatus.OK);
    }
    
}
