package com.example.Offres.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
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

    @JsonManagedReference("Offre_Feedb")
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Feedback> feedbacks = new ArrayList<>();

    @JsonManagedReference("Offre_Candidat")
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "offre_candidat", joinColumns = { @JoinColumn(name = "offre_id") }, inverseJoinColumns = { @JoinColumn(name = "candidat_id") })
    private List<Candidat> candidats = new ArrayList<>();

    @JsonManagedReference("Offre_Entrep")
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
}
