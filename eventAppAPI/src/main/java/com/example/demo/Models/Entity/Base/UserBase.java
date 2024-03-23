package com.example.demo.Models.Entity.Base;

import com.example.demo.Enums.TypeUser;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBase {
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
    //This type create an UUID from IP and timestamp can see in this link: https://thorben-janssen.com/generate-uuids-primary-keys-hibernate

    @Column(name = "id", updatable = false)
    private UUID id;
    @Column(unique = false)
    private String name;

    @Column(unique = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String linkPhoto;

    @Column(nullable = true, unique = true)
    private String showName;

    @Column(unique = false)
    private TypeUser typeUser;
}
