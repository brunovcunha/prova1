package com.iftm.bruno.prova1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.bruno.prova1.model.Rastreamento;
import com.iftm.bruno.prova1.repository.RastreamentoRepository;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository repository;

    public List<Rastreamento> getRastreamentos() {
        return repository.findAll();
    }

}
