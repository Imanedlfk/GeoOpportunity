package com.example.User.controllers;

import com.example.User.model.Entreprise;
import com.example.User.services.EntrepriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
    private final EntrepriseService Service;

    public EntrepriseController(EntrepriseService service) {
        Service = service;
    }

    @GetMapping
    public List<Entreprise> getAll() {
        return Service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getOffresById(@PathVariable long id) {
        return Service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entreprise create(@RequestBody Entreprise entreprise) {

        return Service.save(entreprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> update(@PathVariable long id, @RequestBody Entreprise entreprise) {
        if (Service.getById(id).isPresent()) {
            entreprise.setId(id);
            return ResponseEntity.ok(Service.save(entreprise));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (Service.getById(id).isPresent()) {
            Service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //////////////////////////METIER////////////////////////////////

}

