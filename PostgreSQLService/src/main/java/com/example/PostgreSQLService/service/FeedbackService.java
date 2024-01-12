package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Feedback;
import com.example.PostgreSQLService.model.Offre;
import com.example.PostgreSQLService.repository.FeedbackRepository;
import com.example.PostgreSQLService.repository.OffreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class FeedbackService {

    private final FeedbackRepository Repo;
    private final OffreRepository Repoffre;

    public FeedbackService(FeedbackRepository repo, OffreRepository repoffre) {
        Repo = repo;
        Repoffre = repoffre;
    }

    public List<Feedback> findAll() {
        return Repo.findAll();
    }

    public Optional<Feedback> findById(long id) {
        return Repo.findById(id);
    }

    public Feedback save(Feedback feedback, long offreID) {
        Offre of = Repoffre.findById(offreID)
                .orElseThrow(() -> new EntityNotFoundException("Offre with ID " + offreID + " not found"));
        feedback.setOffre(of);
        System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE "+feedback.getOffre().getId());
        return Repo.save(feedback);
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }
}
