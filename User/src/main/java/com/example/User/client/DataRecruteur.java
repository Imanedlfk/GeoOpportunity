package com.example.User.client;

import com.example.User.model.Recruteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-RECRUTEUR",  url = "${application.config.DataRECRUTEUR-url}")
public interface DataRecruteur {
    @GetMapping("/ByEmail/{email}")
    Recruteur findRecByEmail(@PathVariable("email") String email);

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/{id}")
    Optional<Recruteur> findById(@PathVariable("id")  long id);

    @GetMapping("/All")
    List<Recruteur> findAll();

    @PostMapping("/Add")
    Recruteur save(@RequestBody Recruteur recruteur);
}
