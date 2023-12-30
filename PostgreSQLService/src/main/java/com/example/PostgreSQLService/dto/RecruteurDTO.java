package com.example.PostgreSQLService.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruteurDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;

    private Long entrepriseID;

}