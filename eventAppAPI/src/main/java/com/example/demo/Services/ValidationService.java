package com.example.demo.Services;

import com.example.demo.Models.Validation;
import com.example.demo.Repositories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    private final ValidationRepository validationRepository;

    @Autowired
    public ValidationService(ValidationRepository validationRepository) {
        this.validationRepository = validationRepository;
    }

    public List<Validation> getValidations(){
        return validationRepository.findAll();
    }
}
