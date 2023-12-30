package com.example.PostgreSQLService.controller;

import com.example.PostgreSQLService.model.Candidat;
import com.example.PostgreSQLService.service.CandidatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/candidats")
public class CandidatController {

    private final CandidatService Service;

    public CandidatController(CandidatService service) {
        Service = service;
    }

    @PostMapping("/Add")
    Candidat save(@RequestBody Candidat candidat) {
        return Service.save(candidat);
    }

    @GetMapping("/All")
    List<Candidat> findAll() {
        return Service.findAll();
    }

    @GetMapping("/{id}")
    Optional<Candidat> findById(@PathVariable("id") long id) {
        return Service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        Service.deleteById(id);
    }

    @GetMapping("/ByEmail/{email}")
    Candidat findUserByEmail(@PathVariable("email") String email) {
        return Service.findByEmail(email);
    }

}
