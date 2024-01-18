package com.example.Offres.client;

import com.example.Offres.model.Recruteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-RECRUTEURoffre",  url = "${application.config.DataRECRUTEURoffre-url}")
public interface DataRecruteur {


    @GetMapping("/{id}")
    Optional<Recruteur> findById(@PathVariable("id")  long id);



}
