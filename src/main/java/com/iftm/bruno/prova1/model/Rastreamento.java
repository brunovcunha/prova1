package com.iftm.bruno.prova1.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "rastreamento")
public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRastreio;

    private Date dataHora;
    private String status;
    private String localizacao;


    public String getResumo() {
        return "data-hora: " + dataHora + "/n" +
                "Status: " + status + "/n" +
                "Localizacao: " + localizacao;
    }


    public Rastreamento(Date dataHora, String status, String localizacao) {
        this.dataHora = dataHora;
        this.status = status;
        this.localizacao = localizacao;
    }

    

}
