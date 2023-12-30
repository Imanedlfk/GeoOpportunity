package com.example.User.client;

import com.example.User.model.Candidat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-CANDIDAT",  url = "${application.config.DataCANDIDAT-url}")
public interface Data {

    @PostMapping("/Add")
    Candidat save(@RequestBody Candidat candidat);

    @GetMapping("/All")
    List<Candidat> findAll();

    @GetMapping("/{id}")
    Optional<Candidat> findById(@PathVariable("id")  long id);

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/ByEmail/{email}")
    Candidat findUserByEmail(@PathVariable("email") String email);
}