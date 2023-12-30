package com.example.PostgreSQLService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    private long id;
    private String description;
    private Date date;

    private Long candidatID;
    private String nomComplet;
    private long offreID;
}
