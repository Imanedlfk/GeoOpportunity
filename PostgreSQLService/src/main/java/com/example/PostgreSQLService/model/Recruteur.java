package com.example.PostgreSQLService.model;

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

    @OneToOne
    private Entreprise entreprise;

}