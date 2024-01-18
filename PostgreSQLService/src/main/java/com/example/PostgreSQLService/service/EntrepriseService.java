package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Entreprise;
import com.example.PostgreSQLService.model.Recruteur;
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

    public Entreprise findByName(String nom) {
        return Repo.findByNom(nom);}

    public Entreprise getByRec(Recruteur rec) {
        return Repo.findByRecruteurs(rec);
    }
    //System.out.println("Id OF entreprise : "+ E.getId());
    // return E;
}

