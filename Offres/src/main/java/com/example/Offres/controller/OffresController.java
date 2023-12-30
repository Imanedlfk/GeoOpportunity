package com.example.Offres.controller;

import com.example.Offres.model.Offre;
import com.example.Offres.service.OffresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
public class OffresController {
    private final OffresService Service;
    public OffresController(OffresService service) {
        Service = service;
    }
    @GetMapping
    public List<Offre> getAllOffres() {
        return Service.getAllOffres();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffresById(@PathVariable long id) {
        return Service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Offre createOffres(@RequestBody Offre offre) {

        return Service.save(offre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offre> updateOffres(@PathVariable long id, @RequestBody Offre offre) {
        if (Service.getById(id).isPresent()) {
            offre.setId(id);
            return ResponseEntity.ok(Service.save(offre));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffres(@PathVariable long id) {
        if (Service.getById(id).isPresent()) {
            Service.delete(id);
            System.out.println("here1");
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("here2");
            return ResponseEntity.notFound().build();
        }
    }
    //////////////////////////METIER////////////////////////////////

}

