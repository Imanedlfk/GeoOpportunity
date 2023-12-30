package com.example.PostgreSQLService.repository;

import com.example.PostgreSQLService.model.Candidat;
import com.example.PostgreSQLService.model.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecrutreurRepository extends JpaRepository<Recruteur, Long> {
    @Query("SELECT t FROM  Recruteur t WHERE  t.username = :username")
    Recruteur findByEmail(@Param("username") String username);

}
