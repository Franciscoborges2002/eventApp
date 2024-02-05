package com.example.demo.Models;

import com.example.demo.Enums.TypeUser;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Entity
@Table(name="\"user\"" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*@Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )*/
    //This type create an UUID from IP and timestamp can see in this link: https://thorben-janssen.com/generate-uuids-primary-keys-hibernate/
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

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String linkPhoto;

    @Column(nullable = true, unique = true)
    private String showName;

    @Column(nullable = false, unique = false)
    private TypeUser typeUser;
}
