package com.example.Offres.service;

import com.example.Offres.client.DataEntrep;
import com.example.Offres.model.Entreprise;
import com.example.Offres.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntrepriseService {
    private DataEntrep client;

    public List<Entreprise> getAll() {
        return client.findAll();
    }

    public Optional<Entreprise> getById(long id)  {
        return client.findById(id);
    }

    public Entreprise save(Entreprise entreprise)  {
        return client.save(entreprise);
    }

    public void delete(long id)  {
        client.deleteById(id);
    }


}
