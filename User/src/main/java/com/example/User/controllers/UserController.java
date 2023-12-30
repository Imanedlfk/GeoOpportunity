package com.example.User.controllers;
import com.example.User.model.Recruteur;
import com.example.User.services.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.User.model.Candidat;
import com.example.User.services.CandidatService;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")

public class UserController {

    private final CandidatService candidatService;
    private final RecruteurService recruteurService;

    @Autowired
    public UserController(CandidatService candidatService , RecruteurService recruteurService) {

        this.candidatService = candidatService;
        this.recruteurService = recruteurService;

    }


    /***
    /***Get All User ********/
    @GetMapping("AllCandidates")
    public List<Candidat> getAllCandidates() {

        return candidatService.getAllCandidat();
    }


    /***Add a new  candidate**/
    @PostMapping(value = "/createCandidate")
    public Candidat createCandidateInBase(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam String CV) {


        Candidat candidat = new Candidat();
        candidat.setFirstname(firstname);
        candidat.setLastname(lastname);
        candidat.setUsername(username);
        candidat.setPassword(password);
        candidat.setPhone(phone);
        candidat.setCV(CV);

        return candidatService.saveCandidat(candidat);

    }


    /***Get a candidate by his Id***/
    @GetMapping("/GetCandidate/{id}")
    public Candidat getCandidate(@PathVariable Long id) {
        return candidatService.getCandidatById(id);
    }


    /** Authentification **/
    @PostMapping("/authenticateCand")
    public ResponseEntity<String> authenticate(@RequestParam String email, @RequestParam String password) throws AuthenticationException {
        Candidat candidat = candidatService.authenticate(email, password);

        if (candidat != null) {
            // Authentification réussie
            return new ResponseEntity<>("Authentification réussie.", HttpStatus.OK);
        } else {
            // Authentification échouée
            return new ResponseEntity<>("Email ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }


    /************************Methods for Recruiter******/
    /***
     /***Get All Recruiter ********/
    @GetMapping("AllRecruiters")
    public List<Recruteur> getAllRecruiters() {

        return recruteurService.getAllRec();
    }


    /***Add a new  Recruiter**/
    @PostMapping(value = "/createRecruiter")
    public Recruteur createRecruiterInBase(

            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String phone
           ) {


        Recruteur recruteur = new Recruteur();
        System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERE : "+recruteur.getId());
        recruteur.setFirstname(firstname);
        recruteur.setLastname(lastname);
        recruteur.setUsername(username);
        recruteur.setPassword(password);
        recruteur.setPhone(phone);

        return recruteurService.saveRecruteur(recruteur);
    }

    /** Authentification **/
    @PostMapping("/authenticateRec")
    public ResponseEntity<String> authenticateRec(@RequestParam String email, @RequestParam String password) throws AuthenticationException {
        Recruteur recruteur = recruteurService.authenticate(email, password);

        if (recruteur != null) {
            // Authentification réussie
            return new ResponseEntity<>("Authentification réussie.", HttpStatus.OK);
        } else {
            // Authentification échouée
            return new ResponseEntity<>("Email ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }







}


/*curl -X POST -H "Content-Type: application/json" -d '{
        "firstname": "Asmae",
        "lastname": "ELMANNANI",
        "username": "Asmae.ELM",
        "password": "123",
        "phone": "123456789",
        "CV": "path/to/cv.pdf"
        }' http://localhost:8095/api/createCandidate*/


/**
 *
 * curl -X POST -H "Content-Type: application/json" -d "{\"firstname\": \"Asmae\",\"lastname\": \"ELMANNANI\",\"username\": \"Asmae.ELM\",\"password\": \"123\",\"phone\": \"123456789\",\"CV\": \"pathCV\"}" http://localhost:8095/api/createCandidate
 */