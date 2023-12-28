package com.MysqlService.MysqlService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruteur {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

}