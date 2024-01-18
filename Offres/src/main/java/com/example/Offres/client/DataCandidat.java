package com.example.Offres.client;

import com.example.Offres.model.Candidat;
import com.example.Offres.model.Recruteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Data-service-CANDIDAToffre",  url = "${application.config.DataCANDIDAToffre-url}")
public interface DataCandidat {


    @GetMapping("/GetCandidate/{id}")
    public Candidat getCandidate(@PathVariable Long id);
}