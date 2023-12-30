package com.example.PostgreSQLService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruteur {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;

    @JsonIgnore
    @OneToOne
    private Entreprise entreprise;

}