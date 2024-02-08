package com.example.demo.Services;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Company;
import com.example.demo.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(UUID id){
        Optional<Company> companyById = companyRepository.findById(id);

        if (!companyById.isPresent()) {
            throw new IllegalStateException("Não existe utilizador com esse id");
        }

        return companyById.get();
    }

    public Company getCompanyByType(TypeContract typeContract){
        Optional<Company> companyByContract = companyRepository.findCompanyByTypeContracy(typeContract);

        return companyByContract.get();
    }

    public void addCompany(Company company){

    }
}
