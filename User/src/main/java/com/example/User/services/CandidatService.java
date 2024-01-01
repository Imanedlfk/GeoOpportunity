package com.example.User.services;
import com.example.User.client.Data;
import com.example.User.model.Candidat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;




@Service
@AllArgsConstructor
public class CandidatService{
    private final Data client;


    /**Add New Candidat*/
    public int saveCandidat(Candidat candidat) {

        Candidat cand = findCandidatByEmail(candidat.getUsername());

        if(cand!=null)
        {
            String hashedPassword = BCrypt.hashpw(candidat.getPassword(), BCrypt.gensalt());
            candidat.setPassword(hashedPassword);
            client.save(candidat);
            return 1;
        }else{
            return -1;
        }

    }

    /**Get All candidat ****/
    public List<Candidat> getAllCandidat() {
        List<Candidat> candidatList = client.findAll();

        if (candidatList.isEmpty()) {
            throw new RuntimeException("Aucune candidat trouvée.");
        }

        return candidatList;
    }

    /***Find Candidat by his id ******/
    public Candidat getCandidatById(Long id) {
        return client.findById(id).orElse(null);
    }

    /***Delete canidat from database******/
    public void deleteCandidat(Long id) {
        client.deleteById(id);
    }

    /***Search Candidat by his username******/
    public Candidat findCandidatByEmail(String email) {
        return client.findUserByEmail(email);
    }

    /** Authentification **/
    /** Authentification **/
    public Candidat authenticate(String email, String password) {
        Candidat candidat = findCandidatByEmail(email);

        if (candidat != null && BCrypt.checkpw(password, candidat.getPassword())) {
            return candidat;
        } else {
            return null; // L'authentification a échoué
        }
    }
}

