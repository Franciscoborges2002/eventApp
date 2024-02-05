package com.example.demo.Configs;

import com.example.demo.Enums.TypeUser;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner initiateUser(UserRepository repository) {
        return args -> {
            User user = new User();
            user.setName("Francisco");
            user.setPassword("olaaa");
            user.setEmail("a@a.com");
            user.setShowName("Francisco Borges");
            user.setTypeUser(TypeUser.VISITANTE);
            repository.save(user);
        };
    }
}
