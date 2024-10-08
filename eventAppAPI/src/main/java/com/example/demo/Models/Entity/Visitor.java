package com.example.demo.Models.Entity;

import com.example.demo.Models.Entity.Base.UserBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Entity
@Table(name="visitor" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor extends UserBase {
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

    // relation to Badget
    @ManyToMany
    @JoinTable(
            name = "badges_visitor",
            joinColumns = @JoinColumn(name = "visitor_id"),
            inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private ArrayList<Badge> badges;

    // relation to Validations
    @OneToMany(mappedBy = "visitor")
    private ArrayList<Validation> validations;

    // Relation to Review
    @OneToMany(mappedBy = "visitor")
    private ArrayList<Review> reviews;

    // Relation to Interaction
    @OneToMany(mappedBy = "visitor")
    private ArrayList<Interaction> interactions;

}