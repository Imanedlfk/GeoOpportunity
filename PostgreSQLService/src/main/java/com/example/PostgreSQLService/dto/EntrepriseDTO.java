package com.example.PostgreSQLService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseDTO {
    private long id;
    private String nom;
    private String adresse;
    private String longitude;
    private String latitude;
    private String email;
    private String phone;

    private long recruteurID;
    private List<Long> offresID;
}
