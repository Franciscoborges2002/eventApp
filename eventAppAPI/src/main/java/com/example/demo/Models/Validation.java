package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="validation" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Validation {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

}
