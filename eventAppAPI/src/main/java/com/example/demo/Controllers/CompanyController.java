package com.example.demo.Controllers;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Company;
import com.example.demo.Models.User;
import com.example.demo.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping(path = "{companyId}")
    public Company getUsersById(@PathVariable("companyId") UUID id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping(path = "type/{typeContract}")
    public Company getUsersByType(@PathVariable TypeContract typeContract) {

        //Verificar se a string vinda existe no TipoUtilizador
        return companyService.getCompanyByContractType(typeContract);
    }

    @PostMapping
    public void addUser(@RequestBody Company company) {
        System.out.println("A receber utikizador par acriar");
        companyService.addCompany(company);
    }

    @DeleteMapping(path = "{companyId}")
    public void deleteUser(@PathVariable("companyId") UUID id) {
        System.out.println("A receber utikizador par eliminar");
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "{companyId}")//Receber utilizador inteiro do frontend
    public void updateUser(@PathVariable("companyId") UUID id, @RequestBody Company company) {
        System.out.println("A receber utikizador par mudar");
        companyService.updateCompany(id, company);
    }
}
