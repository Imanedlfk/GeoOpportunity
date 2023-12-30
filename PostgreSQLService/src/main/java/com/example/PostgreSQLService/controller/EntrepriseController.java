package com.example.PostgreSQLService.controller;

import com.example.PostgreSQLService.model.Entreprise;
import com.example.PostgreSQLService.service.EntrepriseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//http://localhost:8095/api/vi/entreprises
@RestController
@RequestMapping("/api/vi/entreprises")
public class EntrepriseController {
    private final EntrepriseService Service;

    public EntrepriseController(EntrepriseService service) {
        Service = service;
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        Service.deleteById(id);
    }

    @PostMapping("/Add")
    Entreprise save(@RequestBody Entreprise entreprise) {
        return Service.save(entreprise);
    }

    @GetMapping("/{id}")
    Optional<Entreprise> findById(@PathVariable("id") long id) {
        return Service.findById(id);
    }

    @GetMapping("/All")
    List<Entreprise> findAll() {
        return Service.findAll();
    }
}
