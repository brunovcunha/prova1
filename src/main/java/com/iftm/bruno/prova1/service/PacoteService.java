package com.iftm.bruno.prova1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.bruno.prova1.model.Pacote;
import com.iftm.bruno.prova1.model.Rastreamento;
import com.iftm.bruno.prova1.repository.PacoteRepository;
import com.iftm.bruno.prova1.repository.RastreamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    @Transactional
    public void addPacote(Pacote pacote) {
        for (Rastreamento rastreamento : pacote.getRastreamentos()) {
            rastreamentoRepository.save(rastreamento);
        }
        repository.save(pacote);
    }
    public List<Pacote> getPacotes() {
        return repository.findAll();
    }

    public Pacote getPacotePorId(Long id) {
        return repository.findById(id).get();
    }

    public void atualizarPacote(Long id, Pacote pacote) {
        Pacote pacoteAtual = getPacotePorId(id);

        pacoteAtual.setDestinatario(pacote.getDestinatario());
        pacoteAtual.setEndereco(pacote.getEndereco());
        pacoteAtual.setId(pacote.getStatus());

        repository.save(pacoteAtual);

    }

    public void deletePacote(Long id) {
        repository.deleteById(id);
    }

}
