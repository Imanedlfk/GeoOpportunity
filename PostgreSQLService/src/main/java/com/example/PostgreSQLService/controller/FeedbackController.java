package com.example.PostgreSQLService.controller;

import com.example.PostgreSQLService.model.Feedback;
import com.example.PostgreSQLService.model.Offre;
import com.example.PostgreSQLService.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/vi/feedbacks")
public class FeedbackController {

    private final FeedbackService Service;

    public FeedbackController(FeedbackService service) {
        Service = service;
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id){
        Service.deleteById(id);
    }

    @PostMapping("/Add/{entrepID}")
    Feedback save(@RequestBody Feedback feedback,@PathVariable("entrepID") long entrepID){
        return Service.save(feedback,entrepID);
    }

    @GetMapping("/{id}")
    Optional<Feedback> findById(@PathVariable("id") long id){
        return Service.findById(id);
    }

    @GetMapping("/All")
    List<Feedback> findAll(){
        return Service.findAll();
    }

}
