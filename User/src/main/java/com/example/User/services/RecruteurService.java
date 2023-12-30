package com.example.User.services;


import com.example.User.client.DataRecruteur;
import com.example.User.model.Recruteur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

@Service
@AllArgsConstructor
public class RecruteurService {

    private final DataRecruteur client;


    /**Add New Recruiter*/
    public Recruteur saveRecruteur(Recruteur recruteur) {

        // Hacher le mot de passe avant de l'enregistrer
        String hashedPassword = BCrypt.hashpw(recruteur.getPassword(), BCrypt.gensalt());
        recruteur.setPassword(hashedPassword);

        return client.save(recruteur);
    }

    /**Get All Recruiter from database ****/
    public List<Recruteur> getAllRec() {
        List<Recruteur> RecList = client.findAll();

        if (RecList.isEmpty()) {
            throw new RuntimeException("Aucune Recruteur trouvée.");
        }

        return RecList;
    }

    /***Find Recruiter by his id ******/
    public Recruteur getRecruiterById(Long id) {
        return client.findById(id).orElse(null);
    }

    /***Delete Recruiter from database******/
    public void deleteRecruiter(Long id) {
        client.deleteById(id);
    }

    /***Search Recruiter by his username******/
    public Recruteur findRecruiterByEmail(String email) {
        return client.findRecByEmail(email);
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
