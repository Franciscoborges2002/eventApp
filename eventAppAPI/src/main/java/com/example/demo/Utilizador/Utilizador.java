package com.example.demo.Utilizador;

import com.example.demo.Enums.TipoUtilizador;
import jakarta.persistence.*;

@Entity
@Table
public class Utilizador {
    @Id
    @SequenceGenerator(
            name = "utilizador_sequence",
            sequenceName = "utilizador_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilizador_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String linkFoto;

    @Column(nullable = false, unique = true)
    private String nomeMostrar;

    @Column(nullable = false, unique = false)
    private TipoUtilizador tipoUtilizador;

    public Utilizador() {
    }

    public Utilizador(String nome, String password, String email, String linkFoto, String nomeMostrar, TipoUtilizador tipoUtilizador) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.linkFoto = linkFoto;
        this.nomeMostrar = nomeMostrar;
        this.tipoUtilizador = tipoUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getNomeMostrar() {
        return nomeMostrar;
    }

    public void setNomeMostrar(String nomeMostrar) {
        this.nomeMostrar = nomeMostrar;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}
