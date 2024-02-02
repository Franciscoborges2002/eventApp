package com.example.demo.Utilizador;

import com.example.demo.Enums.TipoUtilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

    @Query("Select p FROM Utilizador p WHERE p.nome = ?1")
    Optional<Utilizador> findUtilizadorByNome(String nome);

    @Query("Select p FROM Utilizador p WHERE p.email = ?1")
    Optional<Utilizador> findUtilizadorByEmail(String email);

    @Query("Select p FROM Utilizador p WHERE p.nomeMostrar = ?1")
    Optional<Utilizador> findUtilizadorByNomeMostrar(String nomeMostrar);

    @Query("Select p FROM Utilizador p WHERE p.tipoUtilizador = ?1")
    Optional<Utilizador> findUtilizadorByTipoUtilizador(String tipoUtilizador);

}
