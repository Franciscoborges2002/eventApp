package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name="collaborator" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator extends User{
    @OneToMany(mappedBy = "collaborator")
    private ArrayList<Validation> validations;
}
