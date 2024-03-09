package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="validation" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Validation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date validationDateTime;

    //Add activity connection
    @ManyToOne
    @JoinColumn(name="activity_id")
    private Activity activity;


    //Add user connection
    // Add Visitor
    @ManyToOne
    @JoinColumn(name="visitor_id")
    private Visitor visitor;

    //Add person who read the qr cod | collaborator connection
    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator;
}
