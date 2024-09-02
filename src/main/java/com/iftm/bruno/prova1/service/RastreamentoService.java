package com.iftm.bruno.prova1.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.iftm.bruno.prova1.model.Rastreamento;
import com.iftm.bruno.prova1.repository.RastreamentoRepository;

@Service
public class RastreamentoService {

    private RastreamentoRepository repository;

    public RastreamentoService(RastreamentoRepository repository) {
        this.repository = repository;
    }

    public List<Rastreamento> getRastreamentos() {
        return repository.findAll();
    }

}
