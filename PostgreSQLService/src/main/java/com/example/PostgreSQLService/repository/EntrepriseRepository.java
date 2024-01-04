package com.example.PostgreSQLService.repository;

import com.example.PostgreSQLService.model.Entreprise;
import com.example.PostgreSQLService.model.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query("SELECT E FROM  Entreprise E WHERE  E.nom = :nom")
    Entreprise findByNom(@Param("nom") String nom);




}