package com.example.demo.Configs;

import com.example.demo.Models.Entity.Validation;
import com.example.demo.Repositories.ValidationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ValidationConfig {

    @Bean
    CommandLineRunner initiateValidation(ValidationRepository repository) {
        return args -> {
            Validation validation = new Validation();
            validation.setValidationDateTime(new Date());
            repository.save(validation);
        };
    }
}
