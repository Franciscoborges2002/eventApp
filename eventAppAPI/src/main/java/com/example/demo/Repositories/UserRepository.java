package com.example.demo.Repositories;

import com.example.demo.Enums.TypeUser;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("Select p FROM User p WHERE p.name = ?1")
    Optional<User> findUserByName(String name);

    @Query("Select p FROM User p WHERE p.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("Select p FROM User p WHERE p.showName = ?1")
    Optional<User> findUserByShowName(String showName);

    Optional<User> findUserByUserType(String typeUser);

    Optional<User> findUsersByTypeUser(String typeUser);

}
