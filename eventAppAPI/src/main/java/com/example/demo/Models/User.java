package com.example.demo.Models;

import com.example.demo.Enums.TypeUser;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="\"user\"" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

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
