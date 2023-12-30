package com.example.User.services;
import com.example.User.repositories.CandidatRepository;
import com.example.User.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;




@Service
public class CandidatService{
    private final CandidatRepository candidatRepository;


    @Autowired
    public CandidatService(CandidatRepository candRepository) {
        this.candidatRepository = candRepository;

    }

    /**Add New Candidat*/
    public Candidat saveCandidat(Candidat candidat) {

        // Hacher le mot de passe avant de l'enregistrer
        String hashedPassword = BCrypt.hashpw(candidat.getPassword(), BCrypt.gensalt());
        candidat.setPassword(hashedPassword);

        return candidatRepository.save(candidat);
    }

    /**Get All candidat ****/
    public List<Candidat> getAllCandidat() {
        List<Candidat> candidatList = candidatRepository.findAll();

        if (candidatList.isEmpty()) {
            throw new RuntimeException("Aucune candidat trouvée.");
        }

        return candidatList;
    }

    /***Find Candidat by his id ******/
    public Candidat getCandidatById(Long id) {
        return candidatRepository.findById(id).orElse(null);
    }

    /***Delete canidat from database******/
    public void deleteCandidat(Long id) {
        candidatRepository.deleteById(id);
    }

    /***Search Candidat by his username******/
    public Candidat findCandidatByEmail(String email) {
        return candidatRepository.findUserByEmail(email);
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
