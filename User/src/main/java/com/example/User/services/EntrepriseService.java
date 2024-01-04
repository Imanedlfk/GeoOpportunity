package com.example.User.services;

import com.example.User.client.DataEntrep;
import com.example.User.model.Entreprise;
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

    public Entreprise findByName(String name)  {
        return client.findEntrByName(name);
    }

    public void delete(long id)  {
        client.deleteById(id);
    }
}
