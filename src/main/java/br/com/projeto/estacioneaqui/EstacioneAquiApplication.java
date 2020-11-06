package br.com.projeto.estacioneaqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class EstacioneAquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacioneAquiApplication.class, args);
	}

}
