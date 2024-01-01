package com.example.User.client;

import com.example.User.model.Entreprise;
import com.example.User.model.Recruteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "Data-service-ENTRP",  url = "${application.config.DataENTRP-url}")

public interface DataEntrep {

    @GetMapping("/ByName/{nom}")
    Entreprise findEntrByName(@PathVariable("nom") String nom);
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Entreprise save(@RequestBody Entreprise entreprise);

    @GetMapping("/{id}")
    Optional<Entreprise> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Entreprise> findAll();
}
