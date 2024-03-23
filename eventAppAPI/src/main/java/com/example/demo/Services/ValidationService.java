package com.example.demo.Services;

import com.example.demo.Models.Entity.Validation;
import com.example.demo.Repositories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Validation getValidationId(UUID id) {
        Optional<Validation> validationById = validationRepository.findById(id);//Find by the id of the validation

        if (!validationById.isPresent()) {
            throw new IllegalStateException("Não existe validacao com esse id");
        }

        return validationById.get();
    }

    public void addValidation(Validation validation){
//Fazer a logica desta adicao depois
        //Temos so de verifiar que todos os ids necessarios existem

    }

    public void deleteValidation(UUID id){
        boolean bool = validationRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum validacao com esse Id!"));

        }

        validationRepository.deleteById(id);
    }

    public void updateValidation(UUID id, Validation validation){
    //Fazer depois
    }

}
