package com.example.Offres.client;

import com.example.Offres.model.Offre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-OFFRE",  url = "${application.config.DataOFFRE-url}")
public interface Data {

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Offre save(@RequestBody Offre offre);

    @GetMapping("/{id}")
    Optional<Offre> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Offre> findAll();

    @GetMapping(value = "/filtreDC")
    List<Offre> filtreDC(@RequestParam String domaine, @RequestParam String contrat);
}
