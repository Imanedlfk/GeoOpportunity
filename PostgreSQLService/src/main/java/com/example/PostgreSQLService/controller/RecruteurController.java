package com.example.PostgreSQLService.controller;

import com.example.PostgreSQLService.model.Recruteur;
import com.example.PostgreSQLService.service.RecruteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/recruteurs")
public class RecruteurController {

    private final RecruteurService Service;

    public RecruteurController(RecruteurService service) {
        Service = service;
    }

    @GetMapping("/ByEmail/{email}")
    Recruteur findRecByEmail(@PathVariable("email") String email){
        return Service.findByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id){
        Service.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Recruteur> findById(@PathVariable("id")  long id) {
        return Service.findById(id);
    }

    @GetMapping("/All")
    List<Recruteur> findAll() {
        return Service.findAll();
    }

    @PostMapping("/Add")
    Recruteur save(@RequestBody Recruteur recruteur){
        System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERE : "+recruteur.getId());
        return Service.save(recruteur);
    }
}
