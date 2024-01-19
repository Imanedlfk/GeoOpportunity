package com.example.PostgreSQLService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
}
