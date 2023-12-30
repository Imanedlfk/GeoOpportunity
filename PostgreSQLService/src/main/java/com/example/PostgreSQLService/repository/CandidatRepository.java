package com.example.PostgreSQLService.repository;

import com.example.PostgreSQLService.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    @Query("SELECT c FROM Candidat c  WHERE c.username = :username")
    Candidat findByEmail(@Param("username") String username);
}
