package com.example.demo.Models.Entity;

import com.example.demo.Models.Entity.Base.UserBase;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agent extends UserBase {
    private String linkedIn;
    private String contactoTelefonico;

    @ManyToOne()
    @JoinColumn(name="company_id")
    private Company company;
}
