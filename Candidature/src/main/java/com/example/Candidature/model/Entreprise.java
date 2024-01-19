package com.example.Candidature.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String adresse;
    private String email;
    private String phone;


    private Recruteur recruteurs;

    private List<Feedback> feedbacks = new ArrayList<>();

   private List<Offre> offres = new ArrayList<>();
}
