package com.example.User.services;


import com.example.User.model.Recruteur;
import com.example.User.repositories.RecruteurRepository;
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
public class RecruteurService {

    private final RecruteurRepository recruteurRepository;


    @Autowired
    public RecruteurService(RecruteurRepository recRepository) {
        this.recruteurRepository = recRepository;

    }

    /**Add New Recruiter*/
    public Recruteur saveRecruteur(Recruteur recruteur) {

        // Hacher le mot de passe avant de l'enregistrer
        String hashedPassword = BCrypt.hashpw(recruteur.getPassword(), BCrypt.gensalt());
        recruteur.setPassword(hashedPassword);

        return recruteurRepository.save(recruteur);
    }

    /**Get All Recruiter from database ****/
    public List<Recruteur> getAllRec() {
        List<Recruteur> RecList = recruteurRepository.findAll();

        if (RecList.isEmpty()) {
            throw new RuntimeException("Aucune Recruteur trouvée.");
        }

        return RecList;
    }

    /***Find Recruiter by his id ******/
    public Recruteur getRecruiterById(Long id) {
        return recruteurRepository.findById(id).orElse(null);
    }

    /***Delete Recruiter from database******/
    public void deleteRecruiter(Long id) {
        recruteurRepository.deleteById(id);
    }

    /***Search Recruiter by his username******/
    public Recruteur findRecruiterByEmail(String email) {
        return recruteurRepository.findRecByEmail(email);
    }


    /** Authentification **/
    public Recruteur authenticate(String email, String password) {
        Recruteur recruteur = findRecruiterByEmail(email);

        if (recruteur != null && BCrypt.checkpw(password, recruteur.getPassword())) {
            return recruteur;
        } else {
            return null; // L'authentification a échoué
        }
    }
}
