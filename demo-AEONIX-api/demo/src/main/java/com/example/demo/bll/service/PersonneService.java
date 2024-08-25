package com.example.demo.bll.service;

import com.example.demo.api.model.dto.PersonneDTO;
import java.util.List;

public interface PersonneService {

    PersonneDTO getPersonneByNom(String nom);

    PersonneDTO createPersonne(PersonneDTO personneDTO);

    PersonneDTO getPersonneById(Long id);

    PersonneDTO getPersonneById(long id);

    List<PersonneDTO> getAllPersonnes();

    PersonneDTO updatePersonne(Long id, PersonneDTO personneDTO);

    void deletePersonne(Long id);

    PersonneDTO updatePersonne(int id, PersonneDTO personneDTO);

    void deletePersonne(int id);
}





