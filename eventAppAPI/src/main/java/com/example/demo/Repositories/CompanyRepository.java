package com.example.demo.Repositories;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Company;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Query("Select c FROM Company c WHERE c.typeContract = ?1")
    Optional<Company> findCompanyByTypeContracy(TypeContract typeContract);
}
