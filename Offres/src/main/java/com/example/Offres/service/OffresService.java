package com.example.Offres.service;

import com.example.Offres.client.Data;
import com.example.Offres.client.DataCandidat;
import com.example.Offres.client.DataEntrep;
import com.example.Offres.model.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OffresService {

    private Data client;
    private DataEntrep clientEntp;
    private DataCandidat clientCand;

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

    public List<Offre> filtrDomaineContrat(String domaine, String contrat) {
        return client.filtreDC(domaine,contrat);
    }


    //CANDIDATURES
    public List<Offre> getOffresRecrt(Recruteur rec) {
        Entreprise E=clientEntp.getByRec(rec);
        List<Offre> offres=client.findAll();
        List<Offre> finals=new ArrayList<Offre>();
        for(Offre OF:offres){
            if(OF.getEntreprise().equals(E)) finals.add(OF);
        }
        return finals;
    }

    //POSTULE
    public String postulerCandidat(long offreID, long candidatID) {

        Offre offre = client.findById(offreID)
                .orElseThrow(() -> new RuntimeException("Offre not found"));

        Candidat candidat = clientCand.getCandidate(candidatID);

        offre.getCandidats().add(candidat);
        client.save(offre);

        return "Candidat has successfully applied to the job.";


    }

    public List<Feedback> getFeedsByID(long offreId) {
        Optional<Offre> off=client.findById(offreId);
        Entreprise E=off.get().getEntreprise();
        return E.getFeedbacks();
    }
}
