package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select p FROM User p WHERE p.name = ?1")
    Optional<User> findUtilizadorByNome(String nome);

    @Query("Select p FROM User p WHERE p.email = ?1")
    Optional<User> findUtilizadorByEmail(String email);

    @Query("Select p FROM User p WHERE p.showName = ?1")
    Optional<User> findUtilizadorByNomeMostrar(String nomeMostrar);

    @Query("Select p FROM User p WHERE p.typeUser = ?1")
    Optional<User> findUtilizadorByTipoUtilizador(String tipoUtilizador);

}
