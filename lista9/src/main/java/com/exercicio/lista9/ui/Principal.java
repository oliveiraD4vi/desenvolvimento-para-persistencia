package com.exercicio.lista9.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.exercicio.lista9.entity")
@EnableJpaRepositories("com.exercicio.lista9.repository")
public class Principal {

	public static void main(String[] args) {
		SpringApplication.run(CRUDAluno.class, args);
	}

}
