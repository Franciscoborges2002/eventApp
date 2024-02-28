package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="interaction" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Interaction {
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date interactionDateTime;

    //Add company connection
    @Column(name="company")
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    // Add Visitor
    @Column(name="visitor")
    @ManyToOne
    @JoinColumn(name="visitor_id", nullable=false)
    private Visitor visitor;
}
