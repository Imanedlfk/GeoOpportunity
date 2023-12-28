package com.example.PostgreSQLService.repository;

import com.example.PostgreSQLService.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
}
