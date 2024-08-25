package com.example.demo.api.controller;

import com.example.demo.api.model.dto.PersonneDTO;
import com.example.demo.bll.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/nom")
    public ResponseEntity<PersonneDTO> getPersonneByNom(@RequestParam String nom) {
        PersonneDTO personne = personneService.getPersonneByNom(nom);
        if (personne != null) {
            return ResponseEntity.ok(personne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonneDTO> getPersonneById(@PathVariable Long id) {
        PersonneDTO personne = personneService.getPersonneById(id);
        if (personne != null) {
            return ResponseEntity.ok(personne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonneDTO>> getAllPersonnes() {
        List<PersonneDTO> personnes = personneService.getAllPersonnes();
        if (personnes != null && !personnes.isEmpty()) {
            return ResponseEntity.ok(personnes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<PersonneDTO> createPersonne(@RequestBody PersonneDTO personneDTO) {
        PersonneDTO createdPersonne = personneService.createPersonne(personneDTO);
        return ResponseEntity.ok(createdPersonne);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonneDTO> updatePersonne(@PathVariable Long id, @RequestBody PersonneDTO personneDTO) {
        PersonneDTO updatedPersonne = personneService.updatePersonne(id, personneDTO);
        if (updatedPersonne != null) {
            return ResponseEntity.ok(updatedPersonne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.noContent().build();
    }
}




