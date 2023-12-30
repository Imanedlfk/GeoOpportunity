package com.example.Offres.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    private String CV;

    private List<Feedback> feedbacks = new ArrayList<>();

    private List<Offre> offres = new ArrayList<>();
}
