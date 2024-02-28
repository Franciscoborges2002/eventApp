package com.example.demo.Models;

import com.example.demo.Enums.TypeContract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="company" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = false)
    private TypeContract typeContract;

    @Column(nullable = true, unique = false)
    private String NIF;

    @Column(nullable = true, unique = true)
    private String linkLogo;

    @Column(nullable = true, unique = false)
    private String description;

    @Column(nullable = true, unique = false)
    private String localization;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String website;

    @Column(nullable = true, unique = true)
    private String phoneNumber;

    @Column(nullable = true, unique = true)
    private String linkedIn;

    @Column(nullable = true, unique = true)
    private String positionStand;

    /*@Column(nullable = false, unique = false)
    private String keywords;*/

    // Relation to Interaction
    @Column(name = "interaction")
    @OneToMany(mappedBy = "interaction_id")
    private ArrayList<Interaction> interactions;

    //it remains do the connection to collaborators
}
