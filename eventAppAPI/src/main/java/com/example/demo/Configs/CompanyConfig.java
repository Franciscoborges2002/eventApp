package com.example.demo.Configs;

import com.example.demo.Models.Entity.Company;
import com.example.demo.Repositories.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {

    @Bean
    CommandLineRunner initiateCompany(CompanyRepository repository) {
        return args -> {
            Company company = new Company();
            company.setName("Agap2it");
            /*company.setLinkLogo("asd");
            company.setEmail("a@a.com");
            company.setWebsite("asd");
            company.setPhoneNumber("989878");
            company.setLinkedIn("asdasd");
            company.setPositionStand("2a");*/
            repository.save(company);
        };
    }
}
