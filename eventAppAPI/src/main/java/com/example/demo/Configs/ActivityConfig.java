package com.example.demo.Configs;

import com.example.demo.Models.Entity.Activity;
import com.example.demo.Repositories.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivityConfig {
    @Bean
    CommandLineRunner initiateActivity(ActivityRepository repository) {
        return args -> {
            Activity activity = new Activity();
            //activity.setName("Agap2it");

            repository.save(activity);
        };
    }
}
