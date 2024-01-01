package com.example.Offres.client;

import com.example.Offres.model.Entreprise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-ENTRP",  url = "${application.config.DataENTRP-url}")

public interface DataEntrep {
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Entreprise save(@RequestBody Entreprise entreprise);

    @GetMapping("/{id}")
    Optional<Entreprise> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Entreprise> findAll();
}
