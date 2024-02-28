package com.example.demo.Services;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Company;
import com.example.demo.Models.Interaction;
import com.example.demo.Models.Visitor;
import com.example.demo.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            throw new IllegalStateException("Não existe empresa com esse id");
        }

        return companyById.get();
    }

    public Company getCompanyByContractType(TypeContract typeContract){
        Optional<Company> companyByContract = companyRepository.findCompanyByTypeContract(typeContract);

        return companyByContract.get();
    }

    public void addCompany(Company company){
        Optional<Company> companyByName = companyRepository.findCompanyByName(company.getName());

        if (companyByName.isPresent()) {
            throw new IllegalStateException("Ja existe uma empresa com esse nome!");
        }

        //So foi feita a verificacao do nome, depois qualquer coisa e so editar a empresa

        companyRepository.save(company);
    }

    public void deleteCompany(UUID id){
        boolean bool = companyRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma empresa com esse Id"));
        }

        companyRepository.deleteById(id);
    }

    public void updateCompany(UUID id, Company company){

    }


    // get the visitors who interact with the company
    public List<Visitor> getVisitorsByCompany(UUID id) {
        Company company = getCompanyById(id);

        ArrayList<Interaction> interactions = company.getInteractions();

        if(interactions.isEmpty()){
            throw new IllegalStateException(("No ones visits this company, yet"));
        }

        ArrayList<Visitor> visitors = new ArrayList<>();

        for (Interaction i : interactions) {
            visitors.add(i.getVisitor());
            System.out.println("Add a visitor to a list of visitors");
        }

        return visitors;
    }
}
