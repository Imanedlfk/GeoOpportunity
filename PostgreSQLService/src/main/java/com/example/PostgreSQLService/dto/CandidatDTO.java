package com.example.PostgreSQLService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    private String CV;

    private List<Long> feedbacksID;

    private List<Long> offresID;
}
