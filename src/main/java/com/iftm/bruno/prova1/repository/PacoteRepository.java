package com.iftm.bruno.prova1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.bruno.prova1.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long>{
    
}
