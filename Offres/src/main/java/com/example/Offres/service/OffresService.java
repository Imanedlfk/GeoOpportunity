package com.example.Offres.service;

import com.example.Offres.client.Data;
import com.example.Offres.model.Offre;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Offre> getFiltreVille(String ville) {
        List<Offre> offres=client.findAll();
        List<Offre> finals=new ArrayList<Offre>();
        for(Offre OF:offres){
            if(OF.getVille().equals(ville)) finals.add(OF);
        }
        return finals;
    }
}
