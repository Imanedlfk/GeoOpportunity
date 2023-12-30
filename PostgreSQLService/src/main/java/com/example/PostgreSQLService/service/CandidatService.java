package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Candidat;
import com.example.PostgreSQLService.repository.CandidatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    private final CandidatRepository Repo;

    public CandidatService(CandidatRepository repo) {
        Repo = repo;
    }

    public Candidat findByEmail(String email) {
        return Repo.findByEmail(email);
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }

    public Optional<Candidat> findById(long id) {
        return Repo.findById(id);
    }

    public List<Candidat> findAll() {
        return Repo.findAll();
    }

    public Candidat save(Candidat candidat) {
        return Repo.save(candidat);
    }
}
