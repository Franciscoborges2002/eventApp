package com.example.demo.Controllers;

import com.example.demo.Models.Validation;
import com.example.demo.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "validation")
public class ValidationController {

    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @GetMapping
    public List<Validation> getValidation() {
        return validationService.getValidations();
    }
}
