package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Entreprise;
import com.example.PostgreSQLService.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {
    private final EntrepriseRepository Repo;

    public EntrepriseService(EntrepriseRepository repo) {
        Repo = repo;
    }

    public Entreprise save(Entreprise entreprise) {
        return Repo.save(entreprise);
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }

    public Optional<Entreprise> findById(long id) {
        return Repo.findById(id);
    }

    public List<Entreprise> findAll() {
        return Repo.findAll();
    }
}

