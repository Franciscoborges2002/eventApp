package com.example.demo.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="activity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
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
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column(nullable = true, unique = false)
    private String localization;

    @Column(unique = true)
    private int numParticipants;

    @Column(unique = true)
    private boolean required;

    @Column(unique = true)
    private int maxNumParticipants;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date create_at;

    // Relation to activity
    @OneToMany(mappedBy = "activity")
    private ArrayList<Validation> validations;

    // Relation to Review
    @OneToMany(mappedBy = "activity")
    private ArrayList<Review> reviews;

    //@Column(, unique = true)
    //private List speakers;
}
