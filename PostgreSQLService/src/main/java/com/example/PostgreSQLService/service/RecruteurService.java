package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Recruteur;
import com.example.PostgreSQLService.repository.RecrutreurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruteurService {
    private final RecrutreurRepository Repo;

    public RecruteurService(RecrutreurRepository repo) {
        Repo = repo;
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }

    public Optional<Recruteur> findById(long id) {
        return Repo.findById(id);
    }

    public List<Recruteur> findAll() {
        return Repo.findAll();
    }

    public Recruteur save(Recruteur recruteur) {
        return Repo.save(recruteur);
    }


    public Recruteur findByEmail(String email) {
        return Repo.findByEmail(email);
    }

}
