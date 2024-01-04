package com.example.Candidature.controllers;

import com.example.Candidature.model.Feedback;
import com.example.Candidature.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService Service;

    public FeedbackController(FeedbackService service) {
        Service = service;
    }


    @GetMapping
    public List<Feedback> getAllFeedback() {
        return Service.getAllFeedbacks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable long id) {
        return Service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {

        return Service.save(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable long id, @RequestBody Feedback feedback) {
        if (Service.getById(id).isPresent()) {
            feedback.setId(id);
            return ResponseEntity.ok(Service.save(feedback));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable long id) {
        if (Service.getById(id).isPresent()) {
            Service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /////LISTE FEEDBACK D UN OFFRE

}
