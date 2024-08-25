package com.example.demo.dall.repository;

import com.example.demo.domain.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Personne findByNom(String nom);
}



