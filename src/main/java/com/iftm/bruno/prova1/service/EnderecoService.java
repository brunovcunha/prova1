package com.iftm.bruno.prova1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.bruno.prova1.model.Endereco;
import com.iftm.bruno.prova1.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public void addEndereco(Endereco endereco) {
        repository.save(endereco);
    }

    public List<Endereco> getEnderecos() {
        return repository.findAll();
    }
    
}
