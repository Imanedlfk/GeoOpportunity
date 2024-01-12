package com.example.PostgreSQLService.controller;

import com.example.PostgreSQLService.model.Offre;
import com.example.PostgreSQLService.service.OffreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/offres")
public class OffreController {
    private final OffreService Service;

    public OffreController(OffreService service) {
        Service = service;
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        Service.deleteById(id);
    }

    @PostMapping("/Add")
    Offre save(@RequestBody Offre offre) {
        return Service.save(offre);
    }

    @GetMapping("/{id}")
    Optional<Offre> findById(@PathVariable("id") long id) {
        return Service.findById(id);
    }

    @GetMapping("/All")
    List<Offre> findAll() {
        return Service.findAll();
    }


    @GetMapping(value = "/filtreDC")
    List<Offre> filtreDC(@RequestParam String domaine, @RequestParam String contrat){
        return Service.filtreDomContr(domaine,contrat);
    }
}
