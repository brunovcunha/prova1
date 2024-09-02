package com.iftm.bruno.prova1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;


    public String getEnderecoCompleto() {
         return "Rua: " + rua + "/n" +
                "Numero: " + numero + "/n" + 
                "Cidade: " + cidade + "/n" +
                "Estado: " + estado + "/n" +
                "Cep: " + cep;
    }


    public Endereco(String rua, String numero, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    
    
}
