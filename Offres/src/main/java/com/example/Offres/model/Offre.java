package com.example.Offres.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private Date dateCreation;
    private Date dateExpiration;
    private String description;
    private String domaine;
    private String contrat;
    private float longitude;
    private float latitude;

    private List<Feedback> feedbacks = new ArrayList<>();

    private List<Candidat> candidats = new ArrayList<>();

    private Entreprise entreprise;
}
