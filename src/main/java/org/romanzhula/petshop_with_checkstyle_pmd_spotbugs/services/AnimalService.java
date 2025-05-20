package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;

import java.util.List;


public interface AnimalService {

    List<Animal> getAllAnimals();

    Animal getById(Long id);

}
