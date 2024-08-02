package com.iftm.bruno.prova1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iftm.bruno.prova1.model.Endereco;
import com.iftm.bruno.prova1.model.Pacote;


@SpringBootApplication
public class Prova1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Prova1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Date dataAtual = new Date();

		Endereco end = new Endereco("Rua 1", "1", "Teste", "teste", "0000000");

		Pacote pacote = new Pacote("1", "Bruno", end, "pendente");

		pacote.atualizarStatus("em transito", dataAtual, "Uberlandia");
		pacote.atualizarStatus("entregue", dataAtual, "Uberlandia");

		System.out.println(pacote.consultarInformacoes());
	}

}
