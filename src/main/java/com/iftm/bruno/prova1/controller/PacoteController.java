package com.iftm.bruno.prova1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.bruno.prova1.model.Pacote;
import com.iftm.bruno.prova1.service.PacoteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/pacotes")
public class PacoteController {
    

    @Autowired
    private PacoteService service;

    @PostMapping
    public ResponseEntity<Pacote> postPacote(@RequestBody Pacote pacote) {
        
        service.addPacote(pacote);
        return ResponseEntity.ok(pacote);
    }

    @GetMapping
    public ResponseEntity<List<Pacote>> getPacotes() {
        
        List<Pacote> pacotes = service.getPacotes();

        return new ResponseEntity<>(pacotes, HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Pacote> getMethodName(@PathVariable Long id) {
        
        Pacote pacote = service.getPacotePorId(id);
        return new ResponseEntity<>(pacote, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPacote(@PathVariable Long id, @RequestBody Pacote pacote) {

         service.atualizarPacote(id, pacote);
         return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPacote(@PathVariable Long id){

         service.deletePacote(id);

         return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
