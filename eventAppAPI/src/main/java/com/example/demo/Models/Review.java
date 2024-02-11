package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
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
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "starts")
    private double starts;

    @Column(name = "positiveAspects")
    private String positiveAspects;

    //Add activity connection
    @Column(name="activity")
    @ManyToOne
    @JoinColumn(name="activity_id", nullable=false)
    private Activity activity;

    // Add Visitor
    @Column(name="visitor")
    @ManyToOne
    @JoinColumn(name="visitor_id", nullable=false)
    private Visitor visitor;

}
