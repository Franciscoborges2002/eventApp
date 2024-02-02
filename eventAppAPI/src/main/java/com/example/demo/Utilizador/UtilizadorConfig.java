package com.example.demo.Utilizador;

import com.example.demo.Enums.TipoUtilizador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilizadorConfig {

    @Bean
    CommandLineRunner inicializarUtilizador(UtilizadorRepository repository) {
        return args -> {
            Utilizador utilizador = new Utilizador("Franc", "ola", "a@a.com", "linkfoto", "frac bo", TipoUtilizador.VISITANTE);
            repository.save(utilizador);
        };
    }
}
