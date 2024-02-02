package com.example.demo.Utilizador.Visitante;

import com.example.demo.Enums.TipoUtilizador;
import com.example.demo.Utilizador.Utilizador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

import java.util.List;

@Entity
@Inheritance
public class Visitante extends Utilizador {
    @Column(name="pontos")
    private int pontos;
    @Column(name="linkedin")
    private String linkedin;
    @Column(name="linkCV")
    private String linkCV;
    @Column(name="contactoTelefonico")
    private String contactoTelefonico;
    @Column(name="procuraEmprego")
    private boolean procuraEmprego;
    @Column(name="procuraEstagio")
    private boolean procuraEstagio;
    @Column(name="curso")
    private String curso;
    @Column(name="ano")
    private int ano;
    @Column(name="numMecanografico")
    private String numMecanografico;
    //@Column(name="keywords")
    //private String[] keywords;
    @Column(name="eSocio")
    private boolean eSocio;
    @Column(name="atingiuBonificacao")
    private boolean atingiuBonificacao;

    public Visitante() {
    }

    public Visitante(String nome, String password, String email, String linkFoto, String nomeMostrar, TipoUtilizador tipoUtilizador) {
        super(nome, password, email, linkFoto, nomeMostrar, tipoUtilizador);
    }
}
