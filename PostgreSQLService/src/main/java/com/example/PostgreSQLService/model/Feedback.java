package com.example.PostgreSQLService.model;
import jakarta.persistence.Entity;
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
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
}
