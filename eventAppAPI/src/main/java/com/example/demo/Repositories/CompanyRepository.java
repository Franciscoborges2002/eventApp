package com.example.demo.Repositories;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findCompanyByName(String name);

    Optional<Company> findCompanyByTypeContract(TypeContract typeContract);
}
