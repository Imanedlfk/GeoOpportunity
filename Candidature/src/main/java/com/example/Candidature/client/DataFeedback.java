package com.example.Candidature.client;

import com.example.Candidature.model.Feedback;
import com.example.Candidature.model.Offre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-FEEDBACK",  url = "${application.config.DataFEEDBACK-url}")

public interface DataFeedback {
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Feedback save(@RequestBody Feedback feedback,@RequestParam long offreID);

    @GetMapping("/{id}")
    Optional<Feedback> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Feedback> findAll();

}
