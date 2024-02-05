package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

public class Visitor {
    @Column(name="pontos")
    private int points;
    @Column(name="linkedin")
    private String linkedin;
    @Column(name="linkCV")
    private String linkCV;
    @Column(name="contactoTelefonico")
    private String phoneNumber;
    @Column(name="procuraEmprego")
    private boolean searchingJob;
    @Column(name="procuraEstagio")
    private boolean searchingInternship;
    @Column(name="curso")
    private String course;
    @Column(name="ano")
    private int year;
    @Column(name="numMecanografico")
    private String mechanographicNumber;
    //@Column(name="keywords")
    //private String[] keywords;
    @Column(name="eSocio")
    private boolean isMember;
    @Column(name="atingiuBonificacao")
    private boolean reachedBonus;
}