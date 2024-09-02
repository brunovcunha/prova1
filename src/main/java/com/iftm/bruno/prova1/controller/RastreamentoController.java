package com.iftm.bruno.prova1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.bruno.prova1.model.Rastreamento;
import com.iftm.bruno.prova1.service.RastreamentoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("rastreamentos")
public class RastreamentoController {

    private RastreamentoService service;

    public RastreamentoController(RastreamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Rastreamento>> getMethodName() {

        List<Rastreamento> rastreamentos = service.getRastreamentos();

        return new ResponseEntity<>(rastreamentos, HttpStatus.OK);
    }

}
