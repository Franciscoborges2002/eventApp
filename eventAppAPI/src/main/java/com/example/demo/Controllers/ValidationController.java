package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Models.Validation;
import com.example.demo.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "validation")
public class ValidationController {

    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @GetMapping
    public List<Validation> getValidations() {
        return validationService.getValidations();
    }

    @GetMapping(path = "{validationId}")
    public Validation getUsersById(@PathVariable("validationId") UUID id) {
        return validationService.getValidationId(id);
    }

    @PostMapping
    public void addUser(@RequestBody Validation validation) {
        System.out.println("A receber validacao par acriar");
        validationService.addValidation(validation);
    }

    @DeleteMapping(path = "{validationId}")
    public void deleteUser(@PathVariable("validationId") UUID id) {
        System.out.println("A receber validacai par eliminar");
        validationService.deleteValidation(id);
    }

    @PutMapping(path = "{validationId}")//Receber utilizador inteiro do frontend
    public void updateUser(@PathVariable("validationId") UUID id, @RequestBody Validation validation) {
        System.out.println("A receber validacao par mudar");
        validationService.updateValidation(id, validation);
    }
}
