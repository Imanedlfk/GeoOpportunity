package com.example.User.repositories;
import com.example.User.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Long>{

    @Query("SELECT t FROM  Recruteur t WHERE  t.username = :username")
    Recruteur findRecByEmail(@Param("username") String username);
}

