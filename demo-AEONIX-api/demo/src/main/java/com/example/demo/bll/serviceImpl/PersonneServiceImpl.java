package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.dto.PersonneDTO;
import com.example.demo.domain.entities.Personne;
import com.example.demo.dall.repository.PersonneRepository;
import com.example.demo.bll.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public PersonneDTO getPersonneByNom(String nom) {
        Personne personne = personneRepository.findByNom(nom);
        return convertToDTO(personne);
    }

    @Override
    public PersonneDTO createPersonne(PersonneDTO personneDTO) {
        Personne personne = convertToEntity(personneDTO);
        personne = personneRepository.save(personne);
        return convertToDTO(personne);
    }

    @Override
    public PersonneDTO getPersonneById(Long id) {
        Personne personne = personneRepository.findById(id).orElse(null);
        return convertToDTO(personne);
    }

    @Override
    public PersonneDTO getPersonneById(long id) {
        return null;
    }

    @Override
    public List<PersonneDTO> getAllPersonnes() {
        List<Personne> personnes = personneRepository.findAll();
        return personnes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonneDTO updatePersonne(Long id, PersonneDTO personneDTO) {
        Personne personne = personneRepository.findById(id).orElse(null);
        if (personne != null) {
            personne.setNom(personneDTO.getNom());
            personne = personneRepository.save(personne);
        }
        return convertToDTO(personne);
    }

    @Override
    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }

    @Override
    public PersonneDTO updatePersonne(int id, PersonneDTO personneDTO) {
        return null;
    }

    @Override
    public void deletePersonne(int id) {

    }

    private PersonneDTO convertToDTO(Personne personne) {
        if (personne == null) {
            return null;
        }
        PersonneDTO dto = new PersonneDTO();
        dto.setId(personne.getId());
        dto.setNom(personne.getNom());
        return dto;
    }

    private Personne convertToEntity(PersonneDTO dto) {
        if (dto == null) {
            return null;
        }
        Personne personne = new Personne();
        personne.setId(dto.getId());
        personne.setNom(dto.getNom());
        return personne;
    }
}





