package com.iftm.bruno.prova1.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "pacotes")
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacote;

    private String id;
    private String destinatario;

    @ManyToOne
    private Endereco endereco;

    private String status;

    @OneToMany
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {

        Rastreamento rastreamentoAtual = new Rastreamento(dataHora, novoStatus, localizacao);

        if(novoStatus == "pendente" || novoStatus == "em transito" || novoStatus == "entregue") {
            this.status = novoStatus;
            rastreamentos.add(rastreamentoAtual);
        } else {
            throw new RuntimeException("status invalido");
        }

    }

    public String consultarInformacoes() {

        String historicoRastreio = "";

        for (Rastreamento rastreamento : rastreamentos) {
            historicoRastreio += rastreamento.getResumo();
        }

        return  "Id: " + id + "/n" +
                "Destinatario: " + destinatario + "/n" +    
                "Endereco: " + endereco.getEnderecoCompleto() + "/n" +
                "Status: " + status + "/n" +
                "Historico de Rastreio: " + historicoRastreio;
    }

    public Pacote(String id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    
    
}
