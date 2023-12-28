package com.example.Offres.service;

import com.example.Offres.client.Data;
import com.example.Offres.model.Offre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OffresService {

    private Data client;

    public List<Offre> getAllOffres() {
        return client.findAll();
    }

    public Optional<Offre>  getById(long id)  {
        return client.findById(id);
    }

    public Offre save(Offre offre)  {
        return client.save(offre);
    }

    public void delete(long id)  {
        client.deleteById(id);
    }
}
