package com.example.PostgreSQLService.dto;

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
public class OffreDTO {
    private long id;
    private String libelle;
    private Date dateCreation;
    private Date dateExpiration;
    private String description;
    private String domaine;
    private String contrat;

    private List<Long> feedbacksID;

    private List<Long> candidatsID;

    private Long entrepriseID;
}
