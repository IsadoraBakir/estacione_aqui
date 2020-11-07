package br.com.projeto.estacioneaqui;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class EstacioneAquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacioneAquiApplication.class, args);
		
		
////	System.out.println("diferenca: " + ((entrada.getTimeInMillis() - saida.getTimeInMillis())));		
//		
//        LocalTime lt1 = LocalTime.parse(entrada.getTimeInMillis());
//        LocalTime lt2 = LocalTime.parse(saida.toString());
//		
////		System.out.println("entrada: " + entrada.getTime().getMinutes());
////		System.out.println("saida: " + saida.getTime());
////		System.out.println("diferenca: " + (entrada - saida));
//		
//        // também tem outros construtores para utilizar números
//        // diferenca
//        long emHoras = lt1.until(lt2, ChronoUnit.HOURS);
//        long emMinutos = lt1.until(lt2, ChronoUnit.MINUTES);
//        long emSegundos = lt1.until(lt2, ChronoUnit.SECONDS);
//        // etc
//        System.out.println(emHoras);
//        System.out.println(emMinutos);
//        System.out.println(emSegundos);
	}

}
