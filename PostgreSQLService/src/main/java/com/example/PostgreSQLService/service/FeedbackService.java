package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Entreprise;
import com.example.PostgreSQLService.model.Feedback;
import com.example.PostgreSQLService.repository.EntrepriseRepository;
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
    private final EntrepriseRepository Repoentrp;

    public FeedbackService(FeedbackRepository repo, OffreRepository repoffre, EntrepriseRepository repoentrp) {
        Repo = repo;
        Repoffre = repoffre;
        Repoentrp = repoentrp;
    }

    public List<Feedback> findAll() {
        return Repo.findAll();
    }

    public Optional<Feedback> findById(long id) {
        return Repo.findById(id);
    }

    public Feedback save(Feedback feedback, long entrepID) {
        Entreprise of = Repoentrp.findById(entrepID)
                .orElseThrow(() -> new EntityNotFoundException("entreprise with ID " + entrepID + " not found"));
        feedback.setEntreprise(of);
        return Repo.save(feedback);
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }
}
