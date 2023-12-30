package com.example.User.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference("Candidat_Feedb")
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    @JsonBackReference("Offre_Feedb")
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
}
