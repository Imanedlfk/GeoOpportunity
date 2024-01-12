package com.example.PostgreSQLService.repository;

import com.example.PostgreSQLService.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findByDomaineAndContrat(String domaine, String contrat);
}
