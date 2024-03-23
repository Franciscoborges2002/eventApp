package com.example.demo.Models.Entity;

import com.example.demo.Models.Entity.Base.UserBase;
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
public class Collaborator extends UserBase {
    @OneToMany(mappedBy = "collaborator")
    private ArrayList<Validation> validations;
}
