package com.example.Offres.service;


import com.example.Offres.client.DataRecruteur;
import com.example.Offres.model.Recruteur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class RecruteurService {

    private final DataRecruteur client;


    /**Add New Recruiter*/


    /***Find Recruiter by his id ******/
    public Recruteur getRecruiterById(Long id) {
        return client.findById(id).orElse(null);
    }


}
