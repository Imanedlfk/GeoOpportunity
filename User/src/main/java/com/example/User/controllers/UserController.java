package com.example.User.controllers;
import com.example.User.model.Entreprise;
import com.example.User.model.Recruteur;
import com.example.User.services.EntrepriseService;
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

    private final EntrepriseService entrepriseService;

    @Autowired
    public UserController(CandidatService candidatService , RecruteurService recruteurService,EntrepriseService entrepriseService ) {

        this.candidatService = candidatService;
        this.recruteurService = recruteurService;
        this.entrepriseService= entrepriseService;

    }


    /***
    /***Get All User ********/
    @GetMapping("/AllCandidates")
    public List<Candidat> getAllCandidates() {

        return candidatService.getAllCandidat();
    }


    /***Add a new  candidate**/
    @PostMapping(value = "/createCandidate")
    public ResponseEntity<String> createCandidateInBase(
            @RequestBody Candidat candidat
          ) {
        int result = candidatService.saveCandidat(candidat);

        if (result == 1) {
            return ResponseEntity.ok().body("Candidate created successfully");
        } else {
            return ResponseEntity.badRequest().body("Email already exists");
        }
    }


    /***Get a candidate by his Id***/
    @GetMapping("/GetCandidate/{id}")
    public Candidat getCandidate(@PathVariable Long id) {
        return candidatService.getCandidatById(id);
    }


    /** Authentification **/
    @PostMapping("/authenticateCand")
    public ResponseEntity<?> authenticate(@RequestParam String email, @RequestParam String password) throws AuthenticationException {
        Candidat candidat = candidatService.authenticate(email, password);

        if (candidat != null) {
            // Authentification réussie
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        } else {
            // Authentification échouée
            return new ResponseEntity<>("Email ou mot de passe incorrect.", HttpStatus.UNAUTHORIZED);
        }
    }


    /************************Methods for Recruiter******/
    /***
     /***Get All Recruiter ********/
    @GetMapping("/AllRecruiters")
    public List<Recruteur> getAllRecruiters() {

        return recruteurService.getAllRec();
    }


    /***Add a new  Recruiter**/
    @PostMapping(value = "/createRecruiter")
    public ResponseEntity<String>  createRecruiterInBase(

            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam String adresse,
            @RequestParam String nom

    ) {
        Recruteur recruteur = new Recruteur();
        recruteur.setFirstname(firstname);
        recruteur.setLastname(lastname);
        recruteur.setUsername(username);
        recruteur.setPassword(password);
        recruteur.setPhone(phone);

        Entreprise Ent = new Entreprise();
        Ent.setNom(nom);
        Ent.setAdresse(adresse);
       // Ent.setRecruteurs(recruteur);
        Ent.setPhone(phone);
        Ent.setEmail(username);
        Ent.setLatitude("0");
        Ent.setLongitude("0");

        Entreprise EntrepiseTest = entrepriseService.findByName(nom);

        if(EntrepiseTest == null){

            Long result = recruteurService.saveRecruteur(recruteur);



           if (result != -1) {

                Ent.setRecruteurs(recruteurService.getRecruiterById(result));
                System.out.println("Id OF Recuirter : " +recruteur.getId());
                entrepriseService.save(Ent);
                return ResponseEntity.ok().body(" Recruiter And Entreprise created successfully");
            } else {
                return ResponseEntity.badRequest().body("Email already exists");
            }
        }else{
            return ResponseEntity.badRequest().body("Entreprise already exists");
        }

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


