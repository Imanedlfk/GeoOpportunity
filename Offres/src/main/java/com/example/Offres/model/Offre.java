package com.example.Offres.model;

import jakarta.persistence.*;
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
    private String longitude;
    private String latitude;
    private String ville;

    private List<Feedback> feedbacks = new ArrayList<>();

    private List<Candidat> candidats = new ArrayList<>();

    private Entreprise entreprise;
}
