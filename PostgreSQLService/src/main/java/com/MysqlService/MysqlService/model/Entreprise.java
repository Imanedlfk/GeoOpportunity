package com.MysqlService.MysqlService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String adresse;
    private String longitude;
    private String latitude;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Recruteur> recruteurs = new ArrayList<>();


}
