package com.example.PostgreSQLService.service;

import com.example.PostgreSQLService.model.Offre;
import com.example.PostgreSQLService.repository.OffreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreService {
    private final OffreRepository Repo;

    public OffreService(OffreRepository repo) {
        Repo = repo;
    }

    public Offre save(Offre offre) {
        System.out.println("/****************Hi I'm here ************/");
        return Repo.save(offre);
    }

    public void deleteById(long id) {
        Repo.deleteById(id);
    }

    public Optional<Offre> findById(long id) {
        return Repo.findById(id);
    }

    public List<Offre> findAll() {
        return Repo.findAll();
    }
}
